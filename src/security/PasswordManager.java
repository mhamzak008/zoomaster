package security;

import database.DatabaseManager;

public class PasswordManager {

	private static PasswordManager pm = null;
	private String pass;
	
	public PasswordManager(String pass){
		this.pass = pass;
	}
	
	// Changes password
	public void changePassword(String pass){
		this.pass = pass;
		DatabaseManager dm = DatabaseManager.getInstance();
		dm.setPassword(pass);
	}
	
	// Returns if the entered password is correct or not
	public boolean isCorrect(String entry){
		return pass.equals(entry);
	}
	
	// Returns static PasswordManager instance
	public static PasswordManager getInstance(){
		if(pm == null){
			DatabaseManager dm = DatabaseManager.getInstance();
			String password = dm.getPassword();
			pm = new PasswordManager(password);
		}
		return pm;
	}
}
