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
	
	public ServerRunnable(Socket socket, Server theServer) {
		this.socket = socket;
		this.theServer = theServer;
	}

	public void run() {
		
		String name = "";
		boolean login = true;
		
		try {

            // Create character streams for the socket.
            in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            //Get a naam from our new AGENT but he cant already exist
            while (login) {
                
                name = in.readLine();
                if (name == null) {
                	System.out.println(name);
                	out.println("SUBMITNAME");
                    return;
                }
                
                for (Agent a : theServer.getAgentsList()) {
                	if (a.getName().equals(name)) {
                		login = false;
                	}
                }
            }

            // Now that a successful name has been chosen, add the
            // socket's print writer to the set of all writers so
            // this client can receive broadcast messages.
            out.println("NAMEACCEPTED");
            System.out.println(name +  " Has Connected to the Server");
            theServer.addWriter(out);

            // Accept messages from this client and broadcast them.
            // Ignore other clients that cannot be broadcasted to.
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    return;
                }
                for (PrintWriter writer : theServer.getWriters()) {
                    writer.println("MESSAGE " + name + ": " + input);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // This client is going down!  Remove it!
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
