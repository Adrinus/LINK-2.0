package gameplay;

import java.util.Scanner;

public class Address {
	private String IP = "255.255.255.255";

	public Address(int first, int second, int third, int fourth) {
		this.IP = first+"."+second+"."+third+"."+fourth;
	}
	
	// turns a string "255.255.255.255" into an Address (255,255,255,255)
	public Address string2Address(String s){
		Scanner parts = new Scanner(s).useDelimiter("\\s*.\\s*");;
		Address address = new Address(parts.nextInt(),parts.nextInt(),parts.nextInt(),parts.nextInt());
		parts.close();
		return address;
	}
}
