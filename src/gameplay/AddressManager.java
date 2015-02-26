package gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Rand;

public class AddressManager {
	
	List<Address> Addresses = new ArrayList<Address>();
	
		public AddressManager(){
		}
		
		/**
		 * Turns a String IP into an Address and adds it to the Addresses List
		 * @param s   eg: "255.255.255.255"
		 * @return Address  eg: (255,255,255,255)
		 */
		public Address string2Address(String s){
			
			Scanner parts = new Scanner(s).useDelimiter("\\p{Punct}");
			Address address = new Address(parts.nextInt(),parts.nextInt(),parts.nextInt(),parts.nextInt());
			parts.close();
			Addresses.add(address);
			return address;
		}
		
		/**
		 * Returns a part of an Address
		 * @param address
		 * @param part
		 * @return int  eg: 255
		 */
		public int getAddressPart(Address address, int part){
			
			if(part == 1){
				return address.first;
			}
			if(part == 2){
				return address.second;
			}
			if(part == 3){
				return address.third;
			}
			if(part == 4){
				return address.fourth;
			}
			return 255;
		}
		
		/**
		 * Converts an Address into a Formatted IP String
		 * @param a
		 * @return String    eg:"255.255.255.255"
		 */
		public String address2String(Address a){
			
			String s = getAddressPart(a,1) + "." + getAddressPart(a,2) + "." + getAddressPart(a,3) + "." + getAddressPart(a,4);
			return s;
		}
		
		/**
		 * Returns a random Address and adds it to the Addresses List
		 * @return Address  eg:(856,278,457,958)
		 */
		public Address randomAddress(){
			Address a = new Address(Rand.Rand(256, 999),Rand.Rand(256, 999),Rand.Rand(256, 999),Rand.Rand(256, 999));
			Addresses.add(a);
			return a;
		}
}
