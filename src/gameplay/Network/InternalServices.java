package gameplay.Network;

import util.Rand;
import gameplay.Corporation;

public class InternalServices extends Server{

	public InternalServices(Corporation corp, AddressManager am) {
		super(corp);
		this.setName(corp.getName() + " Internal Services");
		corp.addServer(this);
		this.setAddress(am.randomAddress());
		this.setMonitor(Rand.range(2, 3));
		this.setPassword(true);
	}

}
