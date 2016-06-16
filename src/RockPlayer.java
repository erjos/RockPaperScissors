//class of player that only returns Rock
public class RockPlayer extends Player{

	//constructor that creates the name and the rValue
	
	//override method that returns the ENUM
	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}
	
}
