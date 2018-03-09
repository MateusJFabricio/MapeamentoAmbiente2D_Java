package Views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 53, 46, 14);
		add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(25, 91, 46, 14);
		add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(79, 50, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 88, 86, 20);
		add(textField_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(79, 141, 89, 23);
		add(btnLogin);

	}
}
