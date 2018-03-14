package AutoMap.Infraestrucure;

import java.awt.Transparency;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore.TrustedCertificateEntry;
import java.sql.Date;

import javax.sql.rowset.spi.TransactionalWriter;


public class ServerSocketTCP {
	public String nomeConexao;
	public int porta;
	public String hostConectado;
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;
	private Socket cliente;
	private ServerSocket servidor;


	public ServerSocketTCP(int porta){
		abrirConexao(porta);
	}
	
	private void abrirConexao(int porta) {
		try {
	      	// Instancia o ServerSocket ouvindo a porta
	      	servidor = new ServerSocket(porta);
	      	
			// o método accept() bloqueia a execução até que
			// o servidor receba um pedido de conexão
			cliente = servidor.accept();
			
			hostConectado =  cliente.getInetAddress().getHostAddress();
			
			//Instacia os objetos de entrada e saída
			entrada = new ObjectInputStream(cliente.getInputStream());
			saida = new ObjectOutputStream(cliente.getOutputStream());
			
	    }   
	    catch(Exception e) {
	       System.out.println("Erro ao abrir conexao Socket: " + e.getMessage());
	    }

	}
	
	public void fecharConexaoSocket() throws IOException{
		saida.close();
		entrada.close();
		cliente.close();  
	}
	
	
	public void enviarInformacoes(InformacoesSockets info) 
	{
		try {
			saida.flush();
			saida.writeObject(info);
		} catch (IOException e) {
			System.out.println("Erro ao enviar informações Socket: " + e.getMessage());
		}
	}
	
	public InformacoesSockets retornarInformacoes() throws ClassNotFoundException, IOException 
	{
			return (InformacoesSockets) entrada.readObject();		
	}
	
	
	public boolean isConectado() {
		return cliente.isConnected();
	}
	
}
