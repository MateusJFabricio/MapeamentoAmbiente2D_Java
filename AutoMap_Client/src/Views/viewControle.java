package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class viewControle extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			viewControle dialog = new viewControle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public viewControle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.add(panel_2, BorderLayout.EAST);
			
			JButton btnNewButton = new JButton("Manual");
			
			JButton btnAutomatico = new JButton("Automatico");
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
							.addComponent(btnAutomatico, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(22))
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNewButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAutomatico)
						.addContainerGap(199, Short.MAX_VALUE))
			);
			panel_2.setLayout(gl_panel_2);
			
			JPanel panel_1 = new JPanel();
			panel.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.add(panel_3, BorderLayout.NORTH);
			
			JLabel lblControleManual = new JLabel("Controle Manual");
			panel_3.add(lblControleManual);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.add(panel_4, BorderLayout.SOUTH);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			JLabel lblStatu = new JLabel("Status");
			panel_4.add(lblStatu, BorderLayout.NORTH);
			
			JTextPane textPane = new JTextPane();
			panel_4.add(textPane, BorderLayout.SOUTH);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.add(panel_5, BorderLayout.CENTER);
			
			JButton btnNewButton_1 = new JButton("^");
			
			JButton button = new JButton("<");
			
			JButton button_1 = new JButton(">");
			
			JButton btnV = new JButton("v");
			GroupLayout gl_panel_5 = new GroupLayout(panel_5);
			gl_panel_5.setHorizontalGroup(
				gl_panel_5.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_5.createSequentialGroup()
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_5.createSequentialGroup()
								.addGap(112)
								.addComponent(btnNewButton_1))
							.addGroup(gl_panel_5.createSequentialGroup()
								.addGap(68)
								.addComponent(button)
								.addGap(43)
								.addComponent(button_1))
							.addGroup(gl_panel_5.createSequentialGroup()
								.addGap(116)
								.addComponent(btnV)))
						.addContainerGap(122, Short.MAX_VALUE))
			);
			gl_panel_5.setVerticalGroup(
				gl_panel_5.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_5.createSequentialGroup()
						.addGap(37)
						.addComponent(btnNewButton_1)
						.addGap(18)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
							.addComponent(button)
							.addComponent(button_1))
						.addGap(18)
						.addComponent(btnV)
						.addContainerGap(86, Short.MAX_VALUE))
			);
			panel_5.setLayout(gl_panel_5);
		}
	}
}
