package server;

import java.net.Socket;

public class Client {
	
	private int moneys;
	private String nickname;
	private boolean online = false;
	private Socket client;
	
	public Client(String nickname, Socket client) {
		this.nickname = nickname;
		this.client = client;
	}
	
	public void setOnline(boolean online) {
		this.online = online;
	}
	
	public boolean getOnline() {
		return online;
	}
	
	public Socket getSocket() {
		return client;
	}
}
