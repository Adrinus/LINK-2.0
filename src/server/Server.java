package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import agents.Agent;

public class Server {

	public static final int PORT = 9001;

	private List<Agent> agents = new ArrayList<Agent>();
	private List<PrintWriter> writers = new ArrayList<PrintWriter>();

	public void start() throws IOException {
		System.out.println("The chat server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		while (true) {
			Socket socket = listener.accept();
			new Thread(new ServerRunnable(socket, this)).start();
		}
	}

	public List<Agent> getAgentsList() {
		return agents;
	}

	public List<PrintWriter> getWriters() {
		return writers;
	}

	public void addAgent(Agent a) {
		this.agents.add(a);
	}

	public void addWriter(PrintWriter writer) {
		writers.add(writer);
	}

	public Agent getAgent(String name) {
		for (Agent a : agents) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}

	public void setAgentOnline(Agent a) {
		if (!a.equals(null)) {
			a.setOnline(false);
		}
	}

	/**
	 * Main method which simply calls the server and runs it
	 */
	public static void main(String[] args) throws Exception {
		
		
		
		Server myServer = new Server();
		myServer.start();

	}

}
















