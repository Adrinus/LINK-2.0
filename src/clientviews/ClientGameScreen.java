package clientviews;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;

import agents.Agent;

import java.awt.List;

public class ClientGameScreen {
	
	private JFrame frame;
	private JButton connectButton;
	private List list;

	
	public ClientGameScreen() {
		initialize();
	}
	
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 774, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][][][][]"));
		frame.setTitle("LINK 2.0 - TESTBUILD 0.0.1");
		
		list = new List();
		frame.getContentPane().add(list, "cell 0 0");
		
		list.add("Klaas");
		
		connectButton = new JButton("CONNECT");
		frame.getContentPane().add(connectButton, "cell 0 4");
		
		frame.setTitle("hi");
	}
}
