import java.util.Scanner;

public class RoshamboApp {
	public static void main(String[] args) {
		String name;
		String opponent;
		
		String choice = "";
		//creating a variable for the Player class
		Player player = null;
		//variable which determines if the do-while loop restarts
		String restart = "yes";
		//counter for wins
		int win = 0;
		//counter for losses
		int loss = 0;
		//counter for ties
		int ties = 0;

		// prompt user for name
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.println("Enter your name:");
		Scanner input = new Scanner(System.in);

		// get input from the user
		name = input.nextLine();

		// creating the object for the human player with the constructor defined
		// by their choice later
		ThirdPlayer me = new ThirdPlayer(choice);
		me.setName(name);

		// prompt user to select an opponent
		do{
		System.out.println("Would you like to play against 'The Wild Card' or 'This Boring-Ass Dude'? ('wild' or 'boring')");
		opponent = input.nextLine();
		opponent = opponent.toLowerCase();

		// right now you can enter something else and it still lets you move
		// past this point
		switch (opponent) {
		case "wild":
			player = new RandomPlayer();
			player.setName("The Wild Card");
			break;
		case "boring":
			player = new RockPlayer();
			player.setName("Boring-Ass Dude");
			break;
		default:
			//setting the default player to Random so there is always an opponent
			//otherwise there would be an exception if the input didnt match the strings 'wild' or 'boring'
			player = new RandomPlayer();
			player.setName(opponent);
			break;
		}

		// prompt user to select choice rock, paper or scissors
		System.out.println("Do you want to choose 'Rock', 'Paper' or 'Scissors'? ");

		// get choice
		choice = input.nextLine();
		me.setrValue(choice);

		// this calls a method in the ThirdPlayer class that takes the string
		// input and converts it to the correlating ENUM
		me.chooseRoshambo(choice);
		
		//cast the ENUM as a string using concatenation
		//use setrValue to store the players choice
		Roshambo oppo = player.generateRoshambo();
		player.setrValue(""+ oppo);
		
		//create int values for both ENUMs generated using the ordinal() method
		int opp = oppo.ordinal();
		int user = me.generateRoshambo().ordinal();

		// determine winner of the game
		System.out.println(name + ": " + choice);
		System.out.println(player.getName() + ": " + (player.getrValue()).toLowerCase());

		//made a big mistake at first where I would not use a local variable, but put in the generateRoshambo().ordinal.() methods
		// - so that any time I chose the random player I would regenerate the rValue at multiple instances
		
		//Logic that decides which choice wins or loses
		//first two and statements account for if Rock(1) beating Scissors (3)
		//includes counters for the win,loss and tie variables
		if ((user == 0) && (opp == 2)){
			System.out.println(choice + " beats " + (player.getrValue()).toLowerCase());
			System.out.println(me.getName() + " wins!");
			win++;
		}
		else if ((user == 2) && (opp == 0)){
			System.out.println((player.getrValue()).toLowerCase() + " beats " + choice);
			System.out.println(player.getName() + " wins!");
			loss++;
		}
		else if (user > opp){				//remaining logic uses greater than, less than and equals to determine the outcome
			System.out.println(choice + " beats " + (player.getrValue()).toLowerCase());
			System.out.println(me.getName() + " wins!");
			win++;
		}
		else if (user < opp){
			System.out.println((player.getrValue()).toLowerCase() + " beats " + choice);
			System.out.println(player.getName() + " wins!");
			loss++;
		}
		else {
			System.out.println("It's a tie!");
			ties++;
		}
		//prompts user if they would like to continue
		System.out.println("Would you like to play again? (y/n)");
		restart = input.nextLine();
	} while (restart.equalsIgnoreCase("y")); //loops as long as the user selects "y"
	
		//if user selects "n" then this prints out the stats
	System.out.println("Thanks for playing!");
	System.out.println("Wins: " + win);
	System.out.println("Losses: " + loss);
	System.out.println("Ties: " + ties);
	}
}