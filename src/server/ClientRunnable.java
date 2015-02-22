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
		
		client.setOnline(true);
		
		while(!sock.isClosed()) {
			sleep();
		}
		client.setOnline(false);
		System.out.println("Connection to client has been lost");
		
		
		
	}
	
	private void sleep() {
		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// Will be fine :)
		}
	}

}
