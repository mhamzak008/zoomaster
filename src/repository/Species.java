package repository;

import java.awt.image.BufferedImage;

public class Species {

	private String name, latinName, countryOfOrigin, gender, feedingTime; // Due to MySQL constraints feeding time should be in HH:MM:SS format as a string
	private int age, type, ID;
	private BufferedImage image;
	private static int id = 0;
	
	public Species(int type, int ID){
		this.type = type;
		if(id < 0)
			this.ID = id++;
		else
			this.ID = ID;
		name = "";
		latinName = "";
		countryOfOrigin = "";
		gender = "";
		feedingTime = "HH:MM:SS";
		age = 0;
		image = null;
	}
	
	public Species(int type, int ID, int age, BufferedImage image, String...strings){
		this.type = type;
		this.age = age;
		this.image = image;
		name = strings[0];
		feedingTime = strings[1];
		latinName = strings[2];
		countryOfOrigin = strings[3];
		gender = strings[4];
		if(id < 0)
			this.ID = id++;
		else
			this.ID = ID;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getLatinName() {
		// TODO Auto-generated method stub
		return latinName;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return countryOfOrigin;
	}

	public String getFeedingTime() {
		// TODO Auto-generated method stub
		return feedingTime;
	}

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
