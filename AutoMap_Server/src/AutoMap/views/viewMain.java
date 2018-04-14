package AutoMap.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import AutoMap.Controller.ControllerConexao;
import AutoMap.Domains.SocketManager;
import AutoMap.Infraestrucure.ServerSocketTCP;

@SuppressWarnings("serial")
public class viewMain extends JFrame {

	private JPanel contentPane;
	private JTextField edtPortaPadrao;
	private JTable table;
	ServerSocketTCP conexao;
	private JTextField edtMaxConexao;
	private Socket cliente;
	SocketManager gerenteComunicacao;
	public ControllerConexao controller;

	// classe que implementa a interface Callable e retorna um numero aleatorio
    class NovaConexao implements Callable<Socket> {

          public Socket call() {

      			try {
      				conexao = new ServerSocketTCP();
      				cliente = conexao.abrirConexao(12345);
      				
      			} catch (Exception e) {
      				JOptionPane.showMessageDialog(null, "Conexão mal sucedida: " + e.getMessage());
      			}
				return cliente;
          }
          
    }
    
	public viewMain(final ControllerConexao __controller) {
		
		controller = __controller;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					conexao.fecharConexaoSocket();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 361);

		JLabel lblLblipatual = new JLabel("lblIpAtual");
		lblLblipatual.setBounds(116, 38, 74, 14);
		try {
			lblLblipatual.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			throw new IllegalAccessError(e1.getMessage());
		}

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		final JButton btnIniciaSocket = new JButton("Iniciar Socket");
		btnIniciaSocket.setBounds(194, 38, 147, 70);

		JLabel lblIpAtual = new JLabel("Ip Atual:");
		lblIpAtual.setBounds(46, 38, 64, 14);

		JLabel lblPorta = new JLabel("Porta padr\u00E3o:");
		lblPorta.setBounds(24, 63, 86, 14);

		edtPortaPadrao = new JTextField();
		edtPortaPadrao.setText("1234");
		edtPortaPadrao.setBounds(120, 60, 64, 20);
		edtPortaPadrao.setColumns(10);

		table = new JTable();
		table.setBounds(10, 147, 342, 105);

		JLabel lblConexesAtuais = new JLabel("Conex\u00F5es atuais");
		lblConexesAtuais.setBounds(10, 127, 80, 14);

		JButton btnEncerrarConexao = new JButton("Encerrar Conex\u00E3o");
		btnEncerrarConexao.setBounds(10, 270, 155, 23);

		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es");
		lblInformaes.setBounds(24, 11, 105, 14);
		panel.setLayout(null);
		panel.add(btnEncerrarConexao);
		panel.add(table);
		panel.add(lblInformaes);
		panel.add(lblIpAtual);
		panel.add(lblPorta);
		panel.add(edtPortaPadrao);
		panel.add(lblLblipatual);
		panel.add(btnIniciaSocket);
		panel.add(lblConexesAtuais);
		
		JLabel lblNmroMaxConexes = new JLabel("Max. Conex\u00F5es:");
		lblNmroMaxConexes.setBounds(10, 87, 92, 14);
		panel.add(lblNmroMaxConexes);
		
		edtMaxConexao = new JTextField();
		edtMaxConexao.setText("1");
		edtMaxConexao.setBounds(120, 84, 64, 20);
		panel.add(edtMaxConexao);
		edtMaxConexao.setColumns(10);

		JLabel lblLblinformacoes = new JLabel("lblInformacoes");
		contentPane.add(lblLblinformacoes, BorderLayout.SOUTH);
		lblLblinformacoes.setText("Habilite a conexão");
		
		//Add event button
		actionButtons(btnIniciaSocket);
		actionButtons(btnEncerrarConexao);
		
	}
	
	private void actionButtons(final JButton button){
		button.addActionListener(actionListenerBtnIniciaSocket(button));
	}
	
	private ActionListener actionListenerBtnIniciaSocket(final JButton button)
	{
		
		return new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{	
					if (button.getName() == "btnIniciaSocket")
						eventoCliqueBtnIniciaSocket(button);
					if (button.getName() == "btnEncerrarConexao")
						eventoCliquebtnEncerrarConexao(button);
				}
			};
	}
	
	public void eventoCliqueBtnIniciaSocket(JButton __btnIniciaSocket) {
		
		if (__btnIniciaSocket.getText() == "Encerrar servidor") 
		{	
			controller.encerrarServidor();
			
			if (! controller.conexaoIniciada)
				__btnIniciaSocket.setText("Iniciar Socket");
		}
		else
		{
			controller.novaConexao(edtPortaPadrao.getText(), edtMaxConexao.getText());
			
			if (controller.conexaoIniciada)
				__btnIniciaSocket.setText("Encerrar servidor");
		}
	}
	
	public void eventoCliquebtnEncerrarConexao(JButton button) {
		
		//Exibe mensagem de aviso
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja encerrar a conexão?", "Aiaiaii", JOptionPane.YES_NO_OPTION) != 0)
			return;
		
		//		Enviar mensagem de "Conexão encerrada pelo servidor"
		//		Finaliza a conexão do cliente
		//		if (cliente.alive)
		//			JOptionPane.showMessageDialog(null, "O cliente foi desconectado");
		//		
	
	}
	
}
