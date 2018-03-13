package AutoMap.Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class viewConexao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			viewConexao dialog = new viewConexao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public viewConexao() {
		setTitle("Configura\u00E7\u00E3o de Conex\u00E3o");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIp = new JLabel("Endere\u00E7o");
		lblIp.setBounds(10, 53, 87, 14);
		contentPanel.add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setBounds(10, 80, 87, 14);
		contentPanel.add(lblPorta);
		
		JLabel lblNomeDaConexo = new JLabel("Nome da Conex\u00E3o");
		lblNomeDaConexo.setBounds(10, 28, 117, 14);
		contentPanel.add(lblNomeDaConexo);
		
		textField = new JTextField();
		textField.setBounds(137, 25, 178, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 50, 178, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 77, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblExConexo = new JLabel("Ex: Conex\u00E3o 1");
		lblExConexo.setBounds(325, 28, 109, 14);
		contentPanel.add(lblExConexo);
		
		JLabel lblEx = new JLabel("Ex: 192.168.1.1");
		lblEx.setBounds(325, 53, 95, 14);
		contentPanel.add(lblEx);
		
		JLabel lblEx_1 = new JLabel("Ex: 210");
		lblEx_1.setBounds(325, 80, 46, 14);
		contentPanel.add(lblEx_1);
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.setBounds(10, 117, 129, 36);
		contentPanel.add(btnNewButton);
		
		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBounds(291, 117, 129, 36);
		contentPanel.add(btnDesconectar);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblLogDeConexo = new JLabel("Log de conex\u00E3o");
		panel_1.add(lblLogDeConexo);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnTestando = new JTextPane();
		txtpnTestando.setText("Configure uma conex\u00E3o");
		txtpnTestando.setEditable(false);
		panel_2.add(txtpnTestando);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNovo = new JButton("Novo");
		menuBar.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		menuBar.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		menuBar.add(btnExcluir);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		
		JButton btnAterior = new JButton("Anterior");
		menuBar.add(btnAterior);
		
		JButton btnPrximo = new JButton("Pr\u00F3ximo");
		menuBar.add(btnPrximo);
	}
}
