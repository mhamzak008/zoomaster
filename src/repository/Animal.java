package repository;

import java.awt.image.BufferedImage;

public class Animal extends Species{
	
	private char doesHibernate;

	public Animal(int sID){
		super(0, sID);
		doesHibernate = 'N';
	}
	
	public Animal(int sID, char doesHibernate, int age, BufferedImage image, String...strings){
		super(0, sID, age, image, strings[0], strings[1], strings[2], strings[3],strings[4]);
		this.doesHibernate = doesHibernate;
	}

	public char doesHibernate() {
		// TODO Auto-generated method stub
		return doesHibernate;
	}
	


}
