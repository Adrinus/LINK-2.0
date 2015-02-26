package gameplay.Network;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Rand;

public class AddressManager {
	
	List<String> Addresses = new ArrayList<String>();
	
		public AddressManager(){
		}
		
		/**
		 * Turns a String IP into an Address and adds it to the Addresses List
		 * @param s   eg: "255.255.255.255"
		 * @return Address  eg: (255,255,255,255)
		 */
		
		public String randomAddress(){
			String a = Rand.range(256, 999)+"."+Rand.range(256, 999)+"."+Rand.range(256, 999)+"."+Rand.range(256, 999);
			Addresses.add(a);
			return a;
		}
		
}
