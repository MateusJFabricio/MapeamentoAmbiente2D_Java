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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Label;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

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
		
		this.setSize(700, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Projeto");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mnNewMenu.add(mntmNovo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnNewMenu.add(mntmSalvar);
		
		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mnNewMenu.add(mntmFechar);
		
		JMenu mnCriar = new JMenu("Criar");
		menuBar.add(mnCriar);
		
		JMenuItem mntmMapas = new JMenuItem("Mapas");
		mnCriar.add(mntmMapas);
		
		JMenuItem mntmObjetos = new JMenuItem("Objetos");
		mnCriar.add(mntmObjetos);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		
		JMenuItem mntmConexoHw = new JMenuItem("Conex\u00E3o HW");
		mntmConexoHw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewConexao conexao = new viewConexao();
				conexao.setModal(true);
				conexao.show();
			}
		});
		mnConfiguraes.add(mntmConexoHw);
		
		JMenuItem mntmCarregarDoHw = new JMenuItem("Carregar do HW");
		mnConfiguraes.add(mntmCarregarDoHw);
		
		JMenuItem mntmDescarregarNoWh = new JMenuItem("Descarregar no HW");
		mnConfiguraes.add(mntmDescarregarNoWh);
		
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
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Canvas canvas = new Canvas();
		panel_2.add(canvas, BorderLayout.CENTER);
		

	}
}
