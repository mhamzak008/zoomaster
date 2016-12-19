package repository;

public class Animal extends Species{
	
	char doesHibernate;
	
	public Animal(int ID){
		super(0, ID);
		doesHibernate = 'N';
	}
	
	public Animal(int ID, char doesHibernate){
		super(0, ID);
		this.doesHibernate = doesHibernate;
	}

	public char doesHibernate() {
		// TODO Auto-generated method stub
		return doesHibernate;
	}

}
