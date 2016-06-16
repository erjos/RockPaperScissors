//Superclass for Player - this is an abstract class

public abstract class Player {
	private String name;
	private String rValue;
	
	
	public abstract Roshambo generateRoshambo ();


	public String getName() {
		return name;
	}


	public String getrValue() {
		return rValue;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setrValue(String rValue) {
		this.rValue = rValue;
	}
	
}