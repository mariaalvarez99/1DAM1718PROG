import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MenuEclipse extends JFrame implements ActionListener{

	public MenuEclipse() {
		super("Menu eclipse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);
		
		menuItem = new JMenuItem("New");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.ALT_MASK | KeyEvent.SHIFT_MASK));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Open File...");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Open Projects from File System...", new ImageIcon(getClass().getResource("/img/folder.png")));
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Close");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Close All");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Save", new ImageIcon(getClass().getResource("/img/save.png")));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Save As...", new ImageIcon(getClass().getResource("/img/saveas.png")));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Save All", new ImageIcon(getClass().getResource("/img/saveall.png")));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Revert");
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Move");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Rename", new ImageIcon(getClass().getResource("/img/rename.png")));
		menuItem.setAccelerator(KeyStroke.getKeyStroke("F2"));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Refresh", new ImageIcon(getClass().getResource("/img/refresh.png")));
		menuItem.setAccelerator(KeyStroke.getKeyStroke("F5"));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Convert Line Delimiters To");
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Print", new ImageIcon(getClass().getResource("/img/print.png")));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Import", new ImageIcon(getClass().getResource("/img/import.png")));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Export", new ImageIcon(getClass().getResource("/img/export.png")));
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menuItem.setActionCommand("exit");
		menu.add(menuItem);
		 
		
		JToolBar toolBar = new JToolBar();
		
		JButton b = new JButton(new ImageIcon(getClass().getResource("/img/folder.png")));
		b.setActionCommand("Open Projects from File System...");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b);
		
		JButton b2 = new JButton(new ImageIcon(getClass().getResource("/img/save.png")));
		b.setActionCommand("Save");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b2);
		
		JButton b3 = new JButton(new ImageIcon(getClass().getResource("/img/saveas.png")));
		b.setActionCommand("Save as...");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b3);
		
		JButton b4 = new JButton(new ImageIcon(getClass().getResource("/img/saveall.png")));
		b.setActionCommand("Save all");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b4);
		
		JButton b5 = new JButton(new ImageIcon(getClass().getResource("/img/rename.png")));
		b.setActionCommand("Rename");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b5);
		
		JButton b6 = new JButton(new ImageIcon(getClass().getResource("/img/refresh.png")));
		b.setActionCommand("Refresh");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b6);
		
		JButton b7 = new JButton(new ImageIcon(getClass().getResource("/img/print.png")));
		b.setActionCommand("Print");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b7);
		
		JButton b8 = new JButton(new ImageIcon(getClass().getResource("/img/import.png")));
		b.setActionCommand("Import");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b8);
		
		JButton b9 = new JButton(new ImageIcon(getClass().getResource("/img/export.png")));
		b.setActionCommand("Export");
		add(toolBar, BorderLayout.NORTH);
		toolBar.add(b9);
		
		pack();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						new MenuEclipse().setVisible(true);
					}
				}
		);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals("exit")) {
			System.exit(0);
		}
	}

}
