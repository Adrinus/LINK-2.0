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

import client.ClientFunctions;
import agents.Agent;

import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Label;
import javax.swing.JSeparator;
import java.awt.Choice;

public class ClientGameScreen {

	private JFrame frame;
	private JButton connectButton;
	private ClientFunctions clientFunctions;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private List list;
	private JProgressBar progressBar;
	private Label label;
	private List list_1;
	private JButton btnSetTracePoint;

	public ClientGameScreen(ClientFunctions cf) {
		System.out.println(cf);
		clientFunctions = cf;
		initialize();

	}

	private void initialize() {
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		frame.setBounds(100, 100, 949, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new MigLayout("", "[grow]", "[grow][][][][][][]"));
		frame.setTitle("LINK 2.0 - TESTBUILD 0.0.1");
		//frame.getContentPane().add(list, "cell 0 0,grow");
		
		frame.setResizable(false);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		
		panel_1 = new JPanel();
		tabbedPane.addTab("All Agents", null, panel_1, null);
		panel_1.setLayout(null);
		
		list = new List();
		list.setBounds(0, 0, 299, 455);
		panel_1.add(list);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Locations", null, panel, null);
		panel.setLayout(null);
		
		list_1 = new List();
		list_1.setBounds(0, 0, 282, 455);
		panel.add(list_1);
		
		btnSetTracePoint = new JButton("Set Trace Point");
		btnSetTracePoint.setBounds(288, 11, 146, 23);
		panel.add(btnSetTracePoint);
		
		label = new Label("Tracing to you");
		frame.getContentPane().add(label, "cell 0 5,alignx center");
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		frame.getContentPane().add(progressBar, "cell 0 6,growx");
		
		new Thread(new gameUpdate()).start();

	}

	private void setAgentList() {
		list.removeAll();
		for (Agent a : clientFunctions.getAgentsList()) {
			list.add(a.getName() + "  Online: " + a.getOnline());
		}
	}
	
	
	private class gameUpdate implements Runnable {

		public void run() {
			while (true) {
				setAgentList();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				
			}
		}
		
	}
}
