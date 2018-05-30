import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class VP extends JFrame {

	public VP() {
		super("Ejemplo de barra de menú y barra de herramientas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		ImageIcon img = new ImageIcon(getClass().getResource("/img/folder.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setEnabled(false);
		JMenu menu;
		
		JMenuItem menuItem;
		menu = new JMenu("Saludos");
		menu.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menu);
		
		AbstractAction a = new AbstractAction("Por la mañana", img) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(VP.this, "Buenos días", "Saludo", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		a.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_P);
		a.putValue(AbstractAction.ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(KeyEvent.VK_M,
						KeyEvent.ALT_MASK | KeyEvent.CTRL_MASK));
		
		menuItem = new JMenuItem(a);
		menu.add(menuItem);
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(a);
		add(toolBar, BorderLayout.NORTH);
		
		pack();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(
			new Runnable() {
				@Override
				public void run() {
					new VP().setVisible(true);
				}
			}
		);
	}

}
