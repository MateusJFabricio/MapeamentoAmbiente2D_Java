package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProjeto = new JMenu("Projeto");
		menuBar.add(mnProjeto);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao c = new Conexao();
				c.setModal(true);
				c.show();
			}
		});
		mnProjeto.add(mntmNovo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnProjeto.add(mntmAbrir);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnProjeto.add(mntmSalvar);
		
		JMenuItem mntmFecharTudo = new JMenuItem("Fechar");
		mnProjeto.add(mntmFecharTudo);
		
		JMenu mnGerenciar = new JMenu("Criar");
		menuBar.add(mnGerenciar);
		
		JMenuItem mntmMapas = new JMenuItem("Mapas");
		mnGerenciar.add(mntmMapas);
		
		JMenuItem mntmObjetos = new JMenuItem("Objetos");
		mnGerenciar.add(mntmObjetos);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		
		JMenuItem mntmConexoHw = new JMenuItem("Conex\u00E3o HW");
		mnConfiguraes.add(mntmConexoHw);
		
		JMenuItem mntmCarregarDoHw = new JMenuItem("Carregar do Hw");
		mnConfiguraes.add(mntmCarregarDoHw);
		
		JMenuItem mntmDescarregarNoHw = new JMenuItem("Descarregar no Hw");
		mnConfiguraes.add(mntmDescarregarNoHw);
		
		JMenuItem mntmDefMapas = new JMenuItem("Def. Mapas");
		mnConfiguraes.add(mntmDefMapas);
		
		JMenuItem mntmDefObjetos = new JMenuItem("Def. Objetos");
		mnConfiguraes.add(mntmDefObjetos);
		
		JMenu mnDocumentao = new JMenu("Documenta\u00E7\u00E3o");
		menuBar.add(mnDocumentao);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mnDocumentao.add(mntmInicio);
		
		JMenuItem mntmCodFonte = new JMenuItem("Cod. Fonte");
		mnDocumentao.add(mntmCodFonte);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Login panel = new Login();
		contentPane.add(panel, BorderLayout.CENTER);
	}
}
