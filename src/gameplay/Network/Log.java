package gameplay.Network;

import data.Data;

public class Log {
	
	private String to = "";
	private String from = "";
	private String action = "";
	private String text = "";
	private Data data;
	
	public Log(String action, String to, String from, Data data){
		this.action = action;
		this.to = to;
		this.from = from;
		this.data = data;
		if(this.action.equals("access") || this.action.equals("delete")){
			formatLogFile();
		}
		formatLog();
	}
	
	/**
	 * Called after performing an action on a server to format the log's text accordingly
	 */
	public void formatLog(){
		if(this.action.equals("route")){
			this.setText(from + " routed to " + to);
		}
		if(this.action.equals("connect")){
			this.setText(from + " established connection");
		}
		if(this.action.equals("disconnect")){
			this.setText(from + " connection closed");
		}
		if(this.action.equals("admin")){
			this.setText(from + " logged in as admin");
		}
		
	}
	
	/**
	 * Called after performing an action on a server to format the log's text accordingly
	 * Should only be called when accessing or deleting a file
	 */
	public void formatLogFile(){
		if(this.action.equals("access")){
			this.setText(from + " accessed file" + this.data.getName());
		}
		if(this.action.equals("delete")){
			this.setText(from + " deleted file" + this.data.getName());
		}
	}
	
	/**
	 * Returns the formatted text for the log
	 * @return String     eg:"905.644.234.566 established connection"
	 */
	public String getText() {
		return this.text;
	}
	
	
	public void setText(String text) {
		this.text = text;
	}
}
