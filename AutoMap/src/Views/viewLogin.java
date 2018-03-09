package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import javax.swing.JTextField;

public class viewLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			viewLogin dialog = new viewLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public viewLogin() {
		setTitle("Login");
		setResizable(false);
		setType(Type.POPUP);
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 264, 232);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
			lblNewLabel.setBounds(24, 64, 56, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Senha:");
			lblNewLabel_1.setBounds(24, 89, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblSejaBemVindo = new JLabel("Seja bem vindo");
			lblSejaBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblSejaBemVindo.setBounds(51, 11, 160, 28);
			contentPanel.add(lblSejaBemVindo);
		}
		{
			textField = new JTextField();
			textField.setBounds(80, 61, 131, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(80, 86, 131, 20);
			contentPanel.add(textField_1);
		}
		{
			JButton btnLogin = new JButton("Login");
			btnLogin.setBounds(10, 139, 106, 37);
			contentPanel.add(btnLogin);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(142, 139, 106, 37);
			contentPanel.add(btnCancelar);
		}
	}

}
