package corporations;
import java.util.ArrayList;
import java.util.List;

import gameplay.*;

public class Corporation {
	private String name;
	private String alignment = "Neutral";
	private List<Address> servers = new ArrayList<Address>();
	
	public Corporation(String name, String alignment) {
		this.name = name;
		this.alignment = alignment;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAlignment() {
		return alignment;
	}
}
