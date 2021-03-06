//class of player that generates a random result
public class RandomPlayer extends Player{

	//override method that returns the ENUM
	@Override
	public Roshambo generateRoshambo() {
		Roshambo choice;
		//this will generate a random int between 1 and 3
		int random = (int) (Math.random() * 3 + 1);
		
		//switch statement says which number corresponds to the ENUMs
		switch (random){
		case 1: 
			return choice = Roshambo.ROCK;
		case 2:
			return choice = Roshambo.PAPER;
		}
			//needs a final return (so if the randome numer is not 1 or 2 then the return is SCISSORS
			return choice = Roshambo.SCISSORS;
	}
}
