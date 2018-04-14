package AutoMap.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ControllerConexao {
	public boolean conexaoIniciada = false;
	
	public String getIpAtual() {
		String ipAtual;
		try {
			ipAtual = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new IllegalAccessError(e.getMessage());
		}
		return ipAtual;
	}

	public void novaConexao(String portaPadrao, String maxConexao){
		if (portaPadrao.isEmpty())
			throw new IllegalArgumentException("Preencha a porta de conexão");
		
		if (maxConexao.isEmpty())
			throw new IllegalArgumentException("Preencha a quantidade máxima de conexões permitidas");
		
		/*
		gerenteComunicacao = new SocketManager();
		gerenteComunicacao.setMaxConexao(Integer.parseInt(maxConexao));
		gerenteComunicacao.setPortaPadrao(Integer.parseInt(portaPadrao));
		
		try {
			gerenteComunicacao.initConexoesSockets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		conexaoIniciada = true;
		
	}
	
	public void encerrarServidor(){
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja encerrar a conexão?", "Confirma", JOptionPane.YES_NO_OPTION) != 0)
			conexaoIniciada = false;
		else
		{
			//gerenteComunicacao.finalizarTodasConexoes();
			conexaoIniciada = true;
		}
	}
}
