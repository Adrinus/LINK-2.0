package gameplay;

import java.util.Scanner;

public class AddressManager {

		public AddressManager(){
			
		}
		
		/**
		 * Turns a String IP into an Address
		 * @param s   eg: "255.255.255.255"
		 * @return Address  eg: (255,255,255,255)
		 */
		public Address string2Address(String s){
			
			Scanner parts = new Scanner(s).useDelimiter("\\p{Punct}");
			Address address = new Address(parts.nextInt(),parts.nextInt(),parts.nextInt(),parts.nextInt());
			parts.close();
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
}
