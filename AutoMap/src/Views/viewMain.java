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
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;

public class viewMain extends JFrame {
	
	public void Inicia() {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMain frame = new viewMain();
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
	public viewMain() {
		setExtendedState(MAXIMIZED_BOTH);
		Dimension tamanhoMinimoForm = new Dimension(500, 500);
		setMinimumSize(tamanhoMinimoForm);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProjeto = new JMenu("Projeto");
		menuBar.add(mnProjeto);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewConexao c = new viewConexao();
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
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(5, 5, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(99, 5, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JTextPane textPane = new JTextPane();
		panel_5.add(textPane);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_4.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_2.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextPane textPane_1 = new JTextPane();
		panel_2.add(textPane_1, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_7.add(tabbedPane);
		
	}
}
