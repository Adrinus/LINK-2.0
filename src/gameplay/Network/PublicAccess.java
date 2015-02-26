package gameplay.Network;

import gameplay.Corporation;

public class PublicAccess extends Server{

	public PublicAccess(Corporation corp, AddressManager am) {
		super(corp);
		this.setName(corp.getName() + " Public Access Server");
		this.setAddress(am.randomAddress());
		this.setMonitor(3);
		this.setPassword(true);
		corp.addServer(this);
	}

	
}
