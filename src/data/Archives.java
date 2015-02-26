package data;

import java.util.Scanner;

import util.Rand;
import gameplay.Corporation;

public class Archives extends Data{
	private int encryption = 0;
	
	public Archives(int encryption, Corporation corp){
		this.encryption = encryption;
		this.setSize(Rand.range(1,3));
		this.setSize(this.getSize()+(this.getSize()*this.encryption));
		String compressedName = "";
		Scanner sc = new Scanner(corp.getName());
		compressedName = sc.next()+sc.next();
		compressedName = compressedName.substring(0, Math.min(compressedName.length(), (compressedName.length()-(corp.getKind()).length()))+3);
		this.setName(compressedName+"-"+Rand.range(20, 8000));
		sc.close();
	}
	
	/**
	 * Returns the current level of Encryption (1-5)
	 * @return int
	 */
	public int getEncryption(){
		int level = this.encryption;
		return level;
	}
	
	/**
	 * Sets the level of Encryption (1-5)
	 * @param level
	 */
	public void setEncryption(int level){
		this.encryption = level;
	}
		
	
}
