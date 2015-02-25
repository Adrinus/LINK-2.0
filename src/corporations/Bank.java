package corporations;
import java.util.ArrayList;
import java.util.List;

public class Bank extends Corporation{
	public List<Account> accounts = new ArrayList<Account>();
	public Bank(String name, String alignment) {
		super(name, alignment);
	}

}
