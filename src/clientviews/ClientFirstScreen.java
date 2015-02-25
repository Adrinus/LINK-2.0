package clientviews;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SpringLayout;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import client.ClientFunctions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFirstScreen {

	private JFrame frame;
	private JTextField hostName;
	private JLabel lblAgentName;
	private JTextField agentName;
	private JButton connectButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFirstScreen window = new ClientFirstScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientFirstScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ClientFunctions clientFunctions = new ClientFunctions();

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
		frame.setBounds(100, 100, 625, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new MigLayout("", "[grow]", "[][][][][]"));
		frame.setTitle("LINK 2.0 - TESTBUILD 0.0.1");

		JLabel lblDd = new JLabel("IP adres / Hostname");
		frame.getContentPane().add(lblDd, "cell 0 0");

		hostName = new JTextField();
		frame.getContentPane().add(hostName, "cell 0 1,growx");
		hostName.setColumns(10);

		lblAgentName = new JLabel("Agent Name");
		frame.getContentPane().add(lblAgentName, "cell 0 2");

		agentName = new JTextField();
		frame.getContentPane().add(agentName, "cell 0 3,growx");
		agentName.setColumns(10);

		connectButton = new JButton("CONNECT");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String hostNameString = hostName.getText();
				String agentNameString = agentName.getText();

				if (clientFunctions.connect(hostNameString, agentNameString)) {
					System.out.println(clientFunctions);
					ClientGameScreen cgs = new ClientGameScreen(clientFunctions);

					frame.setVisible(false);
				} else {
					JOptionPane
							.showMessageDialog(frame,
									"Oops, something went wrong. Check your input and try again!");
				}

			}
		});
		frame.getContentPane().add(connectButton, "cell 0 4");
	}
}
