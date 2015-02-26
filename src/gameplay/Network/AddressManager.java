package gameplay.Network;

import gameplay.Corporation;

import java.util.ArrayList;
import java.util.List;

import util.Rand;

public class AddressManager {
	
	List<String> Addresses = new ArrayList<String>();
	
		public AddressManager(){
		}
		
		/**
		 * Generates a random IP address, making sure it doesn't match any existing addresses
		 * @return String
		 */
		public String randomAddress(){
			int left = 1;
			String a = "";
			while(left > 0){
				a = Rand.range(256, 999)+"."+Rand.range(256, 999)+"."+Rand.range(256, 999)+"."+Rand.range(256, 999);
				if(Addresses.isEmpty()){
					left = 0;
				}
				for(String address : Addresses){
					if(!a.equals(address)){
						left = 0;
					}
				}
			}
			Addresses.add(a);
			return a;
		}
		
		/**
		 * Returns the list of all addresses
		 * @return List<String>
		 */
		public List<String> getAddresses(){
			return this.Addresses;
		}
		
		public Server getServerFromAddress(String address){
			for(Corporation c: Corporation.getCorporations()){
				for(Server s : c.getServers()){
					if(s.getAddress().equals(address)){
						return s;
					}
				}
			}
			return null;
		}
}
