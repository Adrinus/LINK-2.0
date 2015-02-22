package views;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommandLineView {

	public static void main(String[] args) {
		
		System.out.println("Welcome to LINK2.0");
		System.out.println("Please enter your username:");
		
		Socket MyClient;
	    try {
			MyClient = new Socket("localhost", 200);
			
			DataInputStream input;
		    try {
		       input = new DataInputStream(MyClient.getInputStream());
		    }
		    catch (IOException e) {
		       System.out.println(e);
		    }
		    
		    
		    
		    
			
		} catch (UnknownHostException e) {
			System.out.println("Could not connect to server!");
		} catch (IOException e) {
			System.out.println("Oops, something went wrong..");
		}

	}

}
