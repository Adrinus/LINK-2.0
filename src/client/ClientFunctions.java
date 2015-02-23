package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import agents.Agent;

public class ClientFunctions {
	
	private Socket socket;
	private String hostAdres;
	private List<Agent> agenten = new ArrayList<Agent>();
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
		
		
        try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// IF fail, just return false;
			return false;
		}
        
		
        String line;
		try {
			while (true) {
				line = in.readLine();
				
				
		        if (line.startsWith("SUBMITNAME")) {
		        	
		            out.println(userName);
		        } else if (line.startsWith("NAMEACCEPTED")) {
		        	System.out.println("hi");
		        	break;
		            
		        }
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
	
	/**
	 * Ask the socket to give us a list of agents that are known to the server. This could be to hack them or worse..
	 */
	private void getAgentList() {
		
	}
}
