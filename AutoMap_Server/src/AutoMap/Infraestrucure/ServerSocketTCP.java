package AutoMap.Infraestrucure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerSocketTCP {
	public boolean clienteAdmin;
	public int porta;
	public int portaLivre;
	private ObjectOutputStream dataOutput;
	private ObjectInputStream dataInput;
	private Socket cliente;
	private ServerSocket servidor;
	public InformacoesSockets retorno;
	public InformacoesSockets envio;
	private Date hora = new Date();
	private long timeLastKeepAlive = hora.getTime() ;
	
	public Socket abrirConexao(int porta) throws IOException {
      	
      	servidor = new ServerSocket(porta);
      	return servidor.accept();

	}
	
	public Socket abrirConexaoComPortaLivre() throws IOException {
      	porta = portaLivre;
      	servidor = new ServerSocket(portaLivre);
      	return servidor.accept();

	}
	
	public void fecharConexaoSocket() throws IOException{
		dataOutput.writeChars("Conexão encerrada pelo servidor");
		dataInput.close();
		dataOutput.close();
		cliente.close();  
	}
	
	public void enviarNovaPorta(int porta) 
	{
		try {
			dataOutput.flush();
			dataOutput.writeInt(porta);
		} catch (IOException e) {
			System.out.println("Erro ao enviar tentar nova conexao Socket: " + e.getMessage());
		}
	}
	
	public void enviarKeepAlive(){
		try {
			dataOutput.flush();
			dataOutput.writeChars("Keep Alive");
		} catch (IOException e) {
			System.out.println("Erro ao enviar informações Socket: " + e.getMessage());
		}
	}
	
	public void receberKeepAlive() throws IOException{
		String mensagem = dataInput.readLine(); 
		if ( mensagem == "Keep Alive")
			timeLastKeepAlive = hora.getTime();
	}
	
	public void enviarInformacoes() 
	{
		try {
			dataOutput.flush();
			dataOutput.writeObject(this.envio);
		} catch (IOException e) {
			System.out.println("Erro ao enviar informações Socket: " + e.getMessage());
		}
	}
	
	public void retornarInformacoes() throws ClassNotFoundException, IOException 
	{
			this.retorno = (InformacoesSockets) dataInput.readObject();		
	}
	
	
	
	public boolean isConectado() {
		return cliente.isConnected();
	}
	
	public void limparConexao() throws IOException{
	}
	
}
