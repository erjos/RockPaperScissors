
public class ThirdPlayer extends Player{


	//unique field for this subclass
	Roshambo choice;
	
	//constructor for this subclass based on the roshambo value they input in the main
	public ThirdPlayer (String rValue) {	
	}
	
	
	//method that takes the string input of the user and converts it to the associated ENUM and stores it in the choice variable
	public Roshambo chooseRoshambo(String rValue) {
		if(rValue.equalsIgnoreCase("rock"))
		choice = Roshambo.ROCK;
		else if (rValue.equalsIgnoreCase("paper"))
			choice = Roshambo.PAPER;
		else if (rValue.equalsIgnoreCase("scissors"))
			choice = Roshambo.SCISSORS;
		
		return choice;
	}
	
	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		return choice;
	}
}
