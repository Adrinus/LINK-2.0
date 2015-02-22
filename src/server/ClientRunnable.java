package server;

import java.net.Socket;

public class ClientRunnable implements Runnable {
	
	private Client client;
	private Socket sock;
	
	public ClientRunnable(Client client, Socket sock) {
		this.client = client;
		this.sock = sock;
	}
	
	@Override
	public void run() {
		
		sock.isClosed(); 
		
	}

}
