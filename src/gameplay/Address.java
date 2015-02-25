package gameplay;

public class Address {
	
	int first = 255;
	int second = 255;
	int third = 255;
	int fourth = 255;
	
	public static void main(String[] args) {
		AddressManager am = new AddressManager();
		Address address = am.string2Address("255.255.255.0");
		Address address2 = am.string2Address("127.0.0.1");
		System.out.println(am.address2String(address));
		System.out.println(am.address2String(address2));
	}
	
	/**
	 * Creates an Address from 4 integers
	 * @param f First Integer
	 * @param s Second Integer
	 * @param t Third Integer
	 * @param f2 Fourth Integer
	 */
	public Address(int f, int s, int t, int f2) {
		this.first = f;
		this.second = s;
		this.third = t;
		this.fourth = f2;
	}
	
	
}
