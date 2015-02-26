package gameplay.Network;

import java.util.ArrayList;
import java.util.List;

import gameplay.Corporation;

public class Server {

	private String name = "";
	private String address;
	private Corporation corp;
	private int monitor = 0;
	private int proxy = 0;
	private int firewall = 0;
	private boolean password = false;
	private boolean cypher = false;
	private boolean voice = false;
	private List<Log> logs;
	
	public Server(Corporation corp){
		this.setCorp(corp);
		this.logs = new ArrayList<Log>();
	}
	
	/**
	 * Returns the String Name of the Server
	 * @return String
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Sets the name of the Server
	 * @param name    eg:"SuperSoft Industries Public Access Server"
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Returns the Address of the server
	 * @return Address
	 */
	public String getAddress(){
		return this.address;
	}
	
	/**
	 * Sets the Address of the server
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Returns the level of the Monitor 0-5
	 * @return int
	 */
	public int getMonitor(){
		return this.monitor;
	}
	
	/**
	 * Sets the level of the Monitor
	 * @param level  (0-5)
	 */
	public void setMonitor(int level){
		this.monitor = level;
	}
	
	/**
	 * Returns the level of the Proxy 0-5
	 * @return int
	 */
	public int getProxy(){
		return this.proxy;
	}
	
	/**
	 * Sets the level of the Proxy
	 * @param level  (0-5)
	 */
	public void setProxy(int level){
		this.proxy = level;
	}
	
	/**
	 * Returns the level of the Firewall 0-5
	 * @return int
	 */
	public int getFirewall(){
		return this.firewall;
	}
	
	/**
	 * Sets the level of the Firewall
	 * @param level  (0-5)
	 */
	public void setFirewall(int level){
		this.firewall = level;
	}
	
	/**
	 * Set the server to use or not use password protection
	 * @param bool
	 */
	public void setPassword(boolean bool){
		this.password = bool;
	}
	
	/**
	 * Returns whether password protection is in use
	 * @return boolean
	 */
	public boolean isPassword(){
		return this.password;
	}
	
	/**
	 * Set the server to use or not use an Elliptic Curve Encryption Algorithm
	 * @param bool
	 */
	public void setCypher(boolean bool){
		this.cypher = bool;
	}
	
	/**
	 * Returns whether an elliptic curve encryption algorithm is in use on the server
	 * @return boolean
	 */
	public boolean isCypher(){
		return this.cypher;
	}
	
	/**
	 * Set the server to use or not use voice identification
	 * @param bool
	 */
	public void setVoice(boolean bool){
		this.voice = bool;
	}
	
	/**
	 * Returns whether voice identification is in use on the server
	 * @return
	 */
	public boolean isVoice(){
		return this.voice;
	}
	
	/**
	 * Returns the Corporation of the Server
	 * @return Corporation
	 */
	public Corporation getCorp() {
		return this.corp;
	}
	
	/**
	 * Set the Server's Corporation
	 * @param corp   Corporation
	 */
	public void setCorp(Corporation corp) {
		this.corp = corp;
	}
	
	/**
	 * Returns the list of logs
	 * @return List<Log>
	 */
	public List<Log> getLogs() {
		return logs;
	}
	
	/**
	 * Adds a new log to the list of logs
	 * @param logs
	 */
	public void addLog(Log log) {
		this.logs.add(log);
	}
	
	/**
	 * Removes a matching Log in the list of logs
	 * @param log
	 */
	public void removeLog(Log log){
		for(Log l: logs){
			if(log.equals(l)){
				logs.remove(l);
			}
		}
	}
}
