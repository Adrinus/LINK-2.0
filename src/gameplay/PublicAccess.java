package gameplay;

import gameplay.Network.AddressManager;

public class PublicAccess extends Server{

	public PublicAccess(Corporation corp, AddressManager am) {
		super(corp);
		this.setName(corp.getName() + " Public Access Server");
		corp.addServer(this);
		this.setAddress(am.randomAddress());
		this.setMonitor(3);
		this.setPassword(true);
	}

	
}
