package AutoMap.views;

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
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class viewMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	ServerSocketTCP conexao;

	

	/**
	 * Create the frame.
	 */
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
		setBounds(100, 100, 393, 361);
		
		JLabel lblLblipatual = new JLabel("lblIpAtual");
		try {
			lblLblipatual.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFuncionalidades = new JMenu("Funcionalidades");
		menuBar.add(mnFuncionalidades);
		
		JMenuItem mntmVisualizarLog = new JMenuItem("Visualizar Log");
		mnFuncionalidades.add(mntmVisualizarLog);
		
		JMenuItem mntmAbrirSqliteStudio = new JMenuItem("Abrir SQLite Studio");
		mnFuncionalidades.add(mntmAbrirSqliteStudio);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Iniciar Socket");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conexao = new ServerSocketTCP(12345);
					Button.
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha ao iniciar socket: " + e.getMessage());
				}
				
			}
		});
		
		JLabel lblIpAtual = new JLabel("Ip Atual:");
		
		JLabel lblPorta = new JLabel("Porta:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		table = new JTable();
		
		JLabel lblConexesAtuais = new JLabel("Conex\u00F5es atuais");
		
		JButton btnEncerrarConexo = new JButton("Encerrar Conex\u00E3o");
		
		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConexesAtuais))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGap(24)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblPorta)
										.addGap(18)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblInformaes)
									.addComponent(lblIpAtual)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(48)
										.addComponent(lblLblipatual, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnEncerrarConexo))))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(102)
									.addComponent(lblConexesAtuais))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblIpAtual)
											.addComponent(lblLblipatual))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPorta)))
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
							.addGap(1)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEncerrarConexo))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInformaes)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblLblinformacoes = new JLabel("lblInformacoes");
		contentPane.add(lblLblinformacoes, BorderLayout.SOUTH);
		lblLblinformacoes.setText("Habilite a conexão");
		
	}
}
