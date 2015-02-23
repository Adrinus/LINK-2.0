package client;

import java.net.Socket;

public class ClientFunctions {
	
	private Socket socket;
	private String hostAdres;
	
	
	/**
	 * Connect to a server. This can simply fail or not.
	 * 
	 * NOTE: Has to be updated to give a certain message like username in use or server not connectable
	 * @param host
	 * @param userName
	 * @return
	 */
	public boolean connect(String host, String userName) {
		if (host.equals("") || userName.equals("")) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Give a client a socket which it will need to complete most of his tasks
	 * @param socket
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	
	/**
	 * Set Hostadres for later purposes
	 * @param hostAdres
	 */
	public void setHostAdres(String hostAdres) {
		this.hostAdres = hostAdres;
	}
}
