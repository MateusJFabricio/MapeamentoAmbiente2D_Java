package AutoMap.views;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AutoMap.Infraestrucure.ServerSocketTCP;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class viewMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	ServerSocketTCP conexao;
	private JTextField textField_1;
	private static final ExecutorService threadpool = Executors.newSingleThreadExecutor();
	private Socket cliente;

	/**
	 * Create the frame.
	 */
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
    
	public viewMain() {
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		final JButton button = new JButton("Iniciar Socket");
		button.setBounds(194, 38, 147, 70);

		JLabel lblIpAtual = new JLabel("Ip Atual:");
		lblIpAtual.setBounds(46, 38, 64, 14);

		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(58, 63, 52, 14);

		textField = new JTextField();
		textField.setText("1234");
		textField.setBounds(120, 60, 64, 20);
		textField.setColumns(10);

		table = new JTable();
		table.setBounds(10, 147, 342, 105);

		JLabel lblConexesAtuais = new JLabel("Conex\u00F5es atuais");
		lblConexesAtuais.setBounds(10, 127, 80, 14);

		JButton btnEncerrarConexo = new JButton("Encerrar Conex\u00E3o");
		btnEncerrarConexo.setBounds(10, 270, 155, 23);

		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es");
		lblInformaes.setBounds(24, 11, 105, 14);
		panel.setLayout(null);
		panel.add(btnEncerrarConexo);
		panel.add(table);
		panel.add(lblInformaes);
		panel.add(lblIpAtual);
		panel.add(lblPorta);
		panel.add(textField);
		panel.add(lblLblipatual);
		panel.add(button);
		panel.add(lblConexesAtuais);
		
		JLabel lblNmroMaxConexes = new JLabel("Max. Conex\u00F5es:");
		lblNmroMaxConexes.setBounds(10, 87, 92, 14);
		panel.add(lblNmroMaxConexes);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(120, 84, 64, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblLblinformacoes = new JLabel("lblInformacoes");
		contentPane.add(lblLblinformacoes, BorderLayout.SOUTH);
		lblLblinformacoes.setText("Habilite a conexão");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if ( textField.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Preencha a porta de conexão");
					return;
				}
				
				if ( textField_1.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Preencha a quantidade máxima de conexões permitidas");
					return;
				}
				
				button.setText("Cancelar");
				
				NovaConexao conexao = new NovaConexao();
				
				Future<Socket> future = threadpool.submit(conexao);
				
			}
		});
		
	}
	
}
