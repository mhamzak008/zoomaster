package repository;

import java.awt.image.BufferedImage;

public class Plant extends Species{
	
	private String lightTimeEnd;
	private String lightTimeStart; // Because of MySQL constraints it should be a string in format "HH:MM:SS"

	public Plant(int sID){
		super(1, sID);
		lightTimeStart = "HH:MM:SS";
		lightTimeEnd = "HH:MM:SS";
	}
	
	public Plant(int sID, String lightTimeStart, String lightTimeEnd, int age, BufferedImage image, String...strings){
		super(1	, sID, age, image, strings[0], strings[1], strings[2], strings[3],strings[4]);
		this.lightTimeStart = lightTimeStart;
		this.lightTimeEnd = lightTimeEnd;
	}
	
	public String getLightTimeEnd() {
		// TODO Auto-generated method stub
		return lightTimeEnd;
	}

	public String getLightTimeStart() {
		// TODO Auto-generated method stub
		return lightTimeStart;
	}

}
