package repository;

import java.awt.image.BufferedImage;

public class Plant extends Species{
	
	float lightNeed;
	String lightTime; // Because of MySQL constraints it should be a string in format "HH:MM:SS"

	public Plant(int sID){
		super(1, sID);
		lightNeed = 0;
		lightTime = "HH:MM:SS";
	}
	
	public Plant(int sID, float lightNeed, String lightTime, int age, BufferedImage image, String...strings){
		super(1, sID, age, image, strings[0], strings[1], strings[2], strings[3],strings[4]);
		this.lightNeed = lightNeed;
		this.lightTime = lightTime;
	}
	
	public float getLightNeed() {
		// TODO Auto-generated method stub
		return lightNeed;
	}

	public String getLightTime() {
		// TODO Auto-generated method stub
		return lightTime;
	}

}
