package AutoMap.Domains;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JOptionPane;

import AutoMap.Infraestrucure.ServerSocketTCP;

public class SocketManager {
	private int portaPadrao;
	private int maxConexao;
	private ArrayList<String> portasUtilizadas;
	private ArrayList<ServerSocketTCP> conexoesSockets;
	private Timer timerMonitorComm;
	private Timer timerMonitorThread;
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);
	
	public void initConexoesSockets() throws IOException{
		setMaxConexao(getMaxConexao());
		initPortasUtilizadas();
		this.conexoesSockets = new ArrayList<ServerSocketTCP>();
		aguardarNovaConexao();
	}
	
	public void finalizarTodasConexoes() {
		for (ServerSocketTCP conexao: conexoesSockets) {
			try {
				encerrarConexao(conexao);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		encerrarMonitorComunicacao();
		timerMonitorThread.cancel();
		
	}
	
	// classe que implementa a interface Callable e retorna uma nova conexao
    private static class ThreadNovaConexao implements Callable<ServerSocketTCP> {
    	public int portaPadrao;
    	public int portaLivre;
    	public ServerSocketTCP call() throws IOException {
    		ServerSocketTCP con = new ServerSocketTCP();
    		con.portaLivre = portaLivre;
    		con.abrirConexao(portaPadrao);
			con.enviarNovaPorta(portaLivre);
			con.fecharConexaoSocket();
			//Abre a porta fixa para conexão
			con.abrirConexaoComPortaLivre();
			return con;
		  }
          
    }
    
    private void iniciarTimerTask(){
    	
    	TimerTask tarefa = new TimerTask() {
			private boolean threadIniciada = false;
			private Future<ServerSocketTCP> future;
			private int portaLivre = getPortaDisponivel();
			
			public void novo(){
				try {
					ThreadNovaConexao conexao = new ThreadNovaConexao();
					conexao.portaLivre = portaLivre;
					conexao.portaPadrao = getPortaPadrao();
					
					future = threadpool.submit(conexao);
					threadIniciada = true;
				} catch (Exception e) {
					e.printStackTrace();
					threadIniciada = false;
				}
			}
			
			public void finalizar() throws InterruptedException, ExecutionException{
				if (future.isDone()){
					conexoesSockets.add(future.get());
					setPortasUtilizadas(portaLivre);
					JOptionPane.showMessageDialog(null, "Nova conexão estabelecida");
				}
				
			}
			
			public void run() {
				if (! threadIniciada){
					novo();
				}else{
					try {
						finalizar();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		timerMonitorThread = new Timer();
		timerMonitorThread.scheduleAtFixedRate(tarefa, 1000, 1000);
		
    }
    
	public void aguardarNovaConexao() throws IOException{		
		iniciarTimerTask();
		
	}
	

	private void encerrarMonitorComunicacao() {
		if (timerMonitorComm == null){
			throw new IllegalArgumentException("Não há monitor de comunicação ativo");
		}
		
		timerMonitorComm.cancel();
	}

	public void encerrarConexao(ServerSocketTCP con) throws IOException{
		con.fecharConexaoSocket();
		delPortaUtilizada(con.porta);
	}
	
	public void comunicarSocket(){
		
	}
	
	public int getPortaPadrao() {
		return portaPadrao;
	}
	
	public void setPortaPadrao(int portaPadrao) {
		if (portaPadrao < 1200){
			throw new IllegalArgumentException("Não é permitido portas abaixo de 1200");
		}
		
		if (portaPadrao	> 50000){
			throw new IllegalArgumentException("Não é permitido portas acima de 50000");
		}
		
		this.portaPadrao = portaPadrao;
	}
	
	public int getMaxConexao() {
		if (maxConexao < 1){
			throw new IllegalArgumentException("O número máximo de conexão não deve ser menor que 1");
		}
		return maxConexao;
	}
	
	public void setMaxConexao(int maxConexao) {
		if (maxConexao > 10){
			throw new IllegalArgumentException("Não é permitido mais que 10 conexões");
		}
		
		if (maxConexao < 1){
			throw new IllegalArgumentException("Deve ter ao menos uma conexão habilitada");
		}
		
		this.maxConexao = maxConexao;
	}
	
	public ArrayList<String> getPortasUtilizadas() {
		return portasUtilizadas;
	}
	
	public void initPortasUtilizadas() {
		this.portasUtilizadas = new ArrayList<String>();
	}
	
	public void setPortasUtilizadas(int porta) {
		if (this.portasUtilizadas.size() > this.getMaxConexao()) {
			throw new IllegalArgumentException("Número máximo de conexões atingidas");
		}
		
		this.portasUtilizadas.add(String.valueOf(porta));
	}
	
	public void delPortaUtilizada(int porta){
		//Verifica se há portas utilizadas
		if (this.portasUtilizadas.size() >= 0) {
			throw new IllegalArgumentException("Não há portas utilizadas");
		}
		
		//Remove a porta utilizada		
		if (this.portasUtilizadas.contains(String.valueOf(porta))){
			int index = this.portasUtilizadas.indexOf(String.valueOf(porta));
			this.portasUtilizadas.remove(index);
		}
		
		if (this.portasUtilizadas.size() <= 0){
			encerrarMonitorComunicacao();
		}
	}

	public int getPortaDisponivel(){
		boolean portaEncontrada = true;

		for (int i = getPortaPadrao() + 1; i < (getPortaPadrao() + getMaxConexao() + 1); i++) {
			portaEncontrada = true;
			for (String porta : portasUtilizadas) {
				if (Integer.parseInt(porta) == i){
					portaEncontrada = false;
				}
			}
			
			if (portaEncontrada)
				return i;
		}
		
		throw new IllegalArgumentException("Não há portas disponíveis");
		
	}
	
}
