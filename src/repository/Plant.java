package repository;

public class Plant extends Species{
	
	float lightNeed;
	String lightTime; // Because of MySQL constraints it should be a string in format "HH:MM:SS"

	public Plant(int ID){
		super(1, ID);
		lightNeed = 0;
		lightTime = "HH:MM:SS";
	}
	
	public Plant(int ID, float lightNeed, String lightTime){
		super(1, ID);
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
