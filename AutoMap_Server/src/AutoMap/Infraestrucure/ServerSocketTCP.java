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
		try {
		      	// Instancia o ServerSocket ouvindo a porta
		      	servidor = new ServerSocket(porta);
				// o método accept() bloqueia a execução até que
				// o servidor receba um pedido de conexão
		      	servidor.setSoTimeout(1000);
				cliente = servidor.accept();
				hostConectado =  cliente.getInetAddress().getHostAddress();
				
				entrada = new ObjectInputStream(cliente.getInputStream());
				saida = new ObjectOutputStream(cliente.getOutputStream());
				saida.flush();
		    }   
		    catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		    }
	     
	}
	
	public void EnviarInformacoes(InformacoesSockets info) throws IOException{
		saida.flush();
		saida.writeObject(info);
	}
	
	public InformacoesSockets RetornarInformacoes() throws ClassNotFoundException, IOException {
		return (InformacoesSockets) entrada.readObject();
	}
	
	public void FecharConexaoSocket() throws IOException{
		saida.close();
		entrada.close();
		cliente.close();  
	}
	
	public boolean isConectado() {
		return cliente.isConnected();
	}
	
}
