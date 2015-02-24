package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import agents.Agent;

public class ServerRunnable implements Runnable {
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	private Server theServer;
	private String name = "";

	public ServerRunnable(Socket socket, Server theServer) {
		this.socket = socket;
		this.theServer = theServer;
	}

	public void run() {

		try {

			// Create character streams for the socket.
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			// Get a name from our new AGENT and send him through login
			name = in.readLine();
			if (!login(name)) {
				return;
			} else {
				out.println("NAMEACCEPTED");

				// The user was able to login so add him to our agents list.
				// Also make sure the servers get a graphic reminder
				System.out.println(name + " Has Connected to the Server");
				theServer.addWriter(out);
				theServer.addAgent(new Agent(name, true));

				// Okay, from now on we will probably get some requests by this
				// connected agent. We'll handle them right here.
				while (true) {
					String input = in.readLine();
					if (input == null) {
						return;
					}

					if (input.startsWith("REQUESTDATA")) {
						if (input.equals("REQUESTDATA GETAGENTLIST")) {
							sendAgentList(out);
						}
					}

				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			// This client is going down! Make sure we know its offline;
			try {
				Agent a = theServer.getAgent(name);
				theServer.setAgentOnline(a);
			} catch (NullPointerException e) {

			}

			try {

				socket.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 * Login is a function which simply sends false to a connected socket if
	 * they are not allowed to login
	 * 
	 * @param name
	 */
	public boolean login(String name) {
		if (name.equals("")) {
			out.println("false");
			return false;
		}

		if (name.contains(" ")) {
			out.println("false");
			return false;
		}

		for (Agent a : theServer.getAgentsList()) {
			if (a.getName().equals(name)) {
				out.println("false");
				return false;
			}
		}

		return true;
	}

	/**
	 * Send a list of agents to a client which requested them. We send with it
	 * name and boolean online
	 * 
	 * @param out
	 *            the PrintWriter to send it to
	 */
	public void sendAgentList(PrintWriter out) {
		for (Agent a : theServer.getAgentsList()) {
			out.println(a.getName() + " " + a.getOnline());
		}
		out.println("END");
	}
}
