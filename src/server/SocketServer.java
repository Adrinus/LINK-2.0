package server;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
* A simple socket server
* @author faheem
*
*/
public class SocketServer {
	
	private List<Client> clients = new ArrayList<Client>();
    private ServerSocket serverSocket;
    private int port;
    
    private InputStream in;
    private OutputStream out;
    
    public SocketServer(int port) {
        this.port = port;
    }
    
    public void start() throws IOException {
        System.out.println("Starting the socket server at port:" + port);
        serverSocket = new ServerSocket(port);
        
        
        
        while (true) {
        	System.out.println("Waiting for clients...");
        	Socket client = serverSocket.accept();
        	
        	Client tempClient = new Client("Knapperd", client);

        	clients.add(tempClient);
        	
        	System.out.println("Client connected");
        	new Thread(new ClientRunnable(tempClient, client)).start();
        	
        	for(Client c : clients) {
        		sendStringToClient(c, "Someone has joined the socket");
        	}
        	
        }
    }
    
    private void sendStringToClient(Client client, String text) {


    	PrintWriter out;
		try {
			out = new PrintWriter(client.getSocket().getOutputStream(), true);
			System.out.print("Sending string: '" + text + "'\n");
	        out.print(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    	
    }
    
    public static void main(String[] args) {
        // Setting a default port number.
        int portNumber = 200;
        try {
            // initializing the Socket Server
            SocketServer socketServer = new SocketServer(portNumber);
            socketServer.start();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}