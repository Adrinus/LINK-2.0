package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import agents.Agent;

public class ClientFunctions {
	
	private Socket socket;
	private String hostAdres;
	private List<Agent> agents = new ArrayList<Agent>();
	private SocketFunctions sf = new SocketFunctions();
    private BufferedReader in;
    private PrintWriter out;
	
	
	/**
	 * Connect to a server. This can simply fail or not.
	 * 
	 * NOTE: Has to be updated to give a certain message like username in use or server not connectable
	 * @param host
	 * @param userName
	 * @return
	 */
	public boolean connect(String host, String userName) {
		
		this.hostAdres = hostAdres;
		//Here check if its possible to create a socket else it will fail and return false
		try {
			createSocket();
		} catch (UnknownHostException e) {
			//Server is not reachable
			return false;
		} catch (IOException e) {
			//Illegal action
			return false;
		}
		
		createInOut();
        String line;
		try {
			
				out.println(userName);
				line = in.readLine();	
				

		        if (line.startsWith("NAMEACCEPTED")) {
		        } else if (line.startsWith("false")) {
		        	return false;
		        }
			
		} catch (IOException e) {
			return false;
		}		
		return true;
	}
	
	private void createSocket() throws UnknownHostException, IOException {
        Socket socket = new Socket(hostAdres, 9001);
        this.socket = socket;
	}
	
	public List<Agent> getAgentsList() {
		try {
			getAgentListFromSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something went terribly wrong");
		}
		return this.agents;
	}
	
	/**
	 * Ask the socket to give us a list of agents that are known to the server. This could be to hack them or worse..
	 * @throws IOException 
	 */
	private void getAgentListFromSocket() throws IOException {
		out.println("REQUESTDATA GETAGENTLIST");
		
		agents.clear();
		
		String line = "";
		
		while (true) {
			line = in.readLine();
			if (line.equals("END")) {
				break;
			}
			Scanner lineSc = new Scanner(line);
			
			String name = lineSc.next();
			boolean online = Boolean.parseBoolean(lineSc.next());
			
			agents.add(new Agent(name,online));
		}
		
	}
	
	private boolean createInOut() {
        try {
        	
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// IF fail, just return false;
			return false;
		}
        return true;
	}
	
	public String toString() {
		return Integer.toString(socket.getPort());
	}
}
