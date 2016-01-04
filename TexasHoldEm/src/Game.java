import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static Scanner in;
	static ArrayList<Card> deck;
	static ArrayList<Card> table;
	static int numCPU;
	static long seed;
	static Player human;
	static int chipSetting;
	static int difficulty;
	static ArrayList<CPU> comps;
	static int drawIndex;
	static int pot;
	static Boolean play;
	
	//Plays the first 3 cards of the round
	public static void playFlop() {
		for (int i = 0; i < 3; i ++) {
			table.add(deck.get(drawIndex++));
		}
		System.out.println("The flop is: ");
		printFlop();
		System.out.println("");
		System.out.println("Your hand is: ");
		printHand();
		playBets();
	}
	
	//Prints the three cards of the flop
	public static void printFlop() {
		String[] club = {"|    _    | ",
						 "|   (_)   | ",
						 "|  (_)_)  | ",
						 "|   /_\\   | ",
						 "|         | "};
		String[] diamond = {"|    ,    | ",
							"|   / \\   | ",
							"|  <   >  | ",
							"|   \\ /   | ",
							"|    '    | "};
		String[] heart = {"|   _ _   | ",
						  "|  / ^ \\  | ",
						  "|  \\   /  | ",
						  "|   \\ /   | ",
						  "|    '    | "};
		String[] spade = {"|    ,    | ",
						  "|   / \\   | ",
						  "|  (_ _)  | ",
						  "|   /_\\   | ",
						  "|         | "};
		Card one = table.get(0);
		Card two = table.get(1);
		Card three = table.get(2);
		String valueOne = getValue(one);
		String valueTwo = getValue(two);
		String valueThree = getValue(three);
		System.out.println(" _________   _________   _________ ");
		System.out.println("/         \\ /         \\ /         \\");
		if (!valueOne.equals("10") && !valueTwo.equals("10") && !valueThree.equals("10"))
			System.out.println("|" + valueOne + "        | |" + valueTwo + "        | |" + valueThree + "        |");
		else {
			if (valueOne.equals("10")) System.out.print("|" + valueOne + "       | ");
			else System.out.print("|" + valueOne + "        | ");
			if (valueTwo.equals("10")) System.out.print("|" + valueTwo + "       | ");
			else System.out.print("|" + valueTwo + "        | ");
			if (valueThree.equals("10")) System.out.println("|" + valueThree + "       | ");
			else System.out.println("|" + valueThree + "        | ");
		}
		for (int i = 0; i < 5; i++) {
			switch(one.suit) {
				case 1:
					System.out.print(club[i]);
					break;
					
				case 2:
					System.out.print(diamond[i]);
					break;
					
				case 3:
					System.out.print(heart[i]);
					break;
					
				case 4:
					System.out.print(spade[i]);
					break;
			}
			switch(two.suit) {
				case 1:
					System.out.print(club[i]);
					break;
					
				case 2:
					System.out.print(diamond[i]);
					break;
					
				case 3:
					System.out.print(heart[i]);
					break;
					
				case 4:
					System.out.print(spade[i]);
					break;
			}
			switch(three.suit) {
				case 1:
					System.out.println(club[i]);
					break;
					
				case 2:
					System.out.println(diamond[i]);
					break;
					
				case 3:
					System.out.println(heart[i]);
					break;
					
				case 4:
					System.out.println(spade[i]);
					break;
			}
		}
		if (!valueOne.equals("10") && !valueTwo.equals("10") && !valueThree.equals("10"))
			System.out.println("|        " + valueOne + "| |        " + valueTwo + "| |        " + valueThree + "|");
		else {
			if (valueOne.equals("10")) System.out.print("|       " + valueOne + "| ");
			else System.out.print("|        " + valueOne + "| ");
			if (valueTwo.equals("10")) System.out.print("|       " + valueTwo + "| ");
			else System.out.print("|        " + valueTwo + "| ");
			if (valueThree.equals("10")) System.out.println("|       " + valueThree + "| ");
			else System.out.println("|        " + valueThree + "| ");
		}
		System.out.println("\\_________/ \\_________/ \\_________/");
	}
	
	//Plays the 4th card of the round
	public static void playTurn() {
		
	}
	
	//Plays the 5th and final card of the round
	public static void playRiver() {
		
	}
	
	//Plays the round for the computers
	public static void playComputers() {
		switch(difficulty) {
			case 0:
				CPU.easy();
				break;
				
			case 1:
				CPU.medium();
				break;
				
			case 2:
				CPU.hard();
				break;
				
			case 3:
				CPU.insane();
				break;
		}
	}
	
	//Returns the card's value as a string
	public static String getValue(Card input) {
		String value = "";
		if (input.value == 1 || input.value > 10) {
			switch (input.value) {
				case 11:
					value = "J";
					break;
					
				case 12:
					value = "Q";
					break;
					
				case 13:
					value = "K";
					break;
					
				case 1:
					value = "A";
					break;
					
				default:
					value = " ";
					break;
			}
		}
		else value = Integer.toString(input.value);
		return value;
	}
	
	//Prints the human's cards
	public static void printHand() {
		String[] club = {"|    _    | ",
						 "|   (_)   | ",
						 "|  (_)_)  | ",
						 "|   /_\\   | ",
						 "|         | "};
		String[] diamond = {"|    ,    | ",
							"|   / \\   | ",
							"|  <   >  | ",
							"|   \\ /   | ",
							"|    '    | "};
		String[] heart = {"|   _ _   | ",
						  "|  / ^ \\  | ",
						  "|  \\   /  | ",
						  "|   \\ /   | ",
						  "|    '    | "};
		String[] spade = {"|    ,    | ",
						  "|   / \\   | ",
						  "|  (_ _)  | ",
						  "|   /_\\   | ",
						  "|         | "};
		Card one = human.getCardOne();
		Card two = human.getCardTwo();
		String valueOne = getValue(one);
		String valueTwo = getValue(two);
		System.out.println(" _________   _________ ");
		System.out.println("/         \\ /         \\");
		if (!valueOne.equals("10") && !valueTwo.equals("10"))
			System.out.println("|" + valueOne + "        | |" + valueTwo + "        |");
		else {
			if (valueOne.equals("10")) System.out.print("|" + valueOne + "       | ");
			else System.out.print("|" + valueOne + "        | ");
			if (valueTwo.equals("10")) System.out.println("|" + valueTwo + "       | ");
			else System.out.println("|" + valueTwo + "        | ");
		}
		for (int i = 0; i < 5; i++) {
			switch(one.suit) {
				case 1:
					System.out.print(club[i]);
					break;
					
				case 2:
					System.out.print(diamond[i]);
					break;
					
				case 3:
					System.out.print(heart[i]);
					break;
					
				case 4:
					System.out.print(spade[i]);
					break;
			}
			switch(two.suit) {
				case 1:
					System.out.println(club[i]);
					break;
					
				case 2:
					System.out.println(diamond[i]);
					break;
					
				case 3:
					System.out.println(heart[i]);
					break;
					
				case 4:
					System.out.println(spade[i]);
					break;
			}
		}
		if (!valueOne.equals("10") && !valueTwo.equals("10"))
			System.out.println("|        " + valueOne + "| |        " + valueTwo + "|");
		else {
			if (valueOne.equals("10")) System.out.print("|       " + valueOne + "| ");
			else System.out.print("|        " + valueOne + "| ");
			if (valueTwo.equals("10")) System.out.println("|       " + valueTwo + "| ");
			else System.out.println("|        " + valueTwo + "| ");
		}
		System.out.println("\\_________/ \\_________/");
	}
	
	//Takes the player's and the computers' actions for the round
	public static void playBets() {
		Boolean raise = false;
		Boolean check = false;
		int input = 0;
		System.out.println("Time for bets!");
		System.out.println("Please Enter the number cooresponding with the action you want to take:");
		System.out.println("1. Check");
		System.out.println("2. Bet");
		System.out.println("3. Fold");
		System.out.println("4. Quit Game");
		while(!check) {
			try {
				input = in.nextInt();
				check = true;
			} catch (Exception e) {
				System.out.println("Please enter a valid option.");
			}
		}
		while(!raise) {
			switch(input) {
				case 1:
					System.out.println("You have checked.");
					playComputers();
					break;
					
				case 2:
					System.out.println("Please enter the nunber of chips you would like to bet.");
					while(!check) {
						try {
							input = in.nextInt();
							if (input > 0 && input < human.getNumChips()) check = true;
							else System.out.println("Please enter a valid option.");
						} catch (Exception e) {
							System.out.println("Please enter a valid option.");
						}
					}
					int holder = human.getNumChips();
					human.setNumChips(holder - input);
					pot += holder;
					playComputers();
					break;
					
				case 3:
					System.out.println("You have folded for this round.");
					//TODO: Play computers until end game
					break;
					
				case 4:
					shutdown();
					break;
			}
		}
	}
	
	/*
	 * Creates a new deck in numerical order
	 * Suit guide:
	 * 1 = clubs
	 * 2 = diamonds
	 * 3 = hearts
	 * 4 = spades
	 * 
	 * Card value guide:
	 * 1 = Ace
	 * 2-10 = Corresponding number card
	 * 11 = Jack
	 * 12 = Queen
	 * 13 = King
	 */
	public static void initializeDeck() {
		deck = new ArrayList<Card>();
		table = new ArrayList<Card>();
		drawIndex = 0;
		Card temp;
		//Loop for each suit
		for (int i = 1; i < 4; i++) {
			//Loop for each card
			for (int j = 1; j < 13; j++) {
				temp = new Card();
				temp.setSuit(i);
				temp.setValue(j);
				deck.add(temp);
			}
		}
		return;
	}
	
	//Shuffles the deck randomly
	
	//Shuffles the deck
	public static void shuffle() {
		seed = System.nanoTime();
		Collections.shuffle(deck, new Random(seed));
		return;
	}
	
	//Deals two cards to the human and all computers
	
	//Deals the cards to the player and all CPUs
	public static void deal() {
		for (int i = 0; i < comps.size(); i++) {
			comps.get(i).setCardOne(deck.get(drawIndex++));
			comps.get(i).setCardTwo(deck.get(drawIndex++));
		}
		
		human.setCardOne(deck.get(drawIndex++));
		human.setCardTwo(deck.get(drawIndex++));
		return;
	}
	
	//Initializes deck for play, shuffles the deck, and deals cards
	
	//Setup the deck for the first time and shuffle the cards for a new game
	public static void start() {
		System.out.println("Setting up deck...");
		initializeDeck();
		System.out.println("Shuffling cards...");
		shuffle();
		System.out.println("Dealing hands...");
		deal();
		System.out.println("");
		return;
	}
	
	//Creates computers and sets their initial chip values
	public static void initializeCPU() {
		comps = new ArrayList<CPU>();
		for (int i = 0; i < numCPU; i++) {
			CPU temp = new CPU();
			temp.setNumChips(chipSetting);
			comps.add(temp);
		}
		return;
	}

	//Prints the rules
	public static void rules() {
		System.out.println("Here are the rules for Texas Hold'em:");
		System.out.println("You and all the other players will be dealt two cards.");
		System.out.println("Then three cards will be played on the table. These three cards are called the flop.");
		System.out.println("After the flop is shown, you may bet chips (which typically represent money).");
		System.out.println("If you or a different player bets, every player must match that amount, raise the amount, or give up for the round (known as folding).");
		System.out.println("You bet based on your odds of winning. If you think you will win, bet more chips. If you think you will lose, bet nothing or fewer chips.");
		System.out.println("To win, you must have the highest hand of all the players. Hand strength is determined by the combination of cards dealt to you and on the table.");
		System.out.println("You can only use the two cards dealt to you and three cards on the table to make your combinations.");
		System.out.println("The combinations occur as follows in increasing strength:");
		System.out.println("High Card: If none of the following combinations occur, the highest card wins. If face values match, the suit determines the winner as follows.");
		System.out.println("(Clubs < Diamonds < Hearts < Spades) Meaning, Spades is the highest suit and worth the most and Clubs is the lowest and worth the least.");
		System.out.println("Pair: Two cards with the same value (I.E. Two 2's, Two Kings, etc)");
		System.out.println("Two Pair: Two Pairs (I.E. Two 2's and Two Kings, Two 5's and Two Aces, etc.)");
		System.out.println("Three-of-a-kind: As the name implies, any three cards of the same face value. (I.E. Three Queen's, Three 4's, etc)");
		System.out.println("Straight: Five cards in sequential order with at least two different suits (I.E. 2, 3, 4, 5, 6 / 9, 10, J, Q, K, A / etc)");
		System.out.println("Flush: Five cards of any value with the same suit (I.E. Five Hearts, Five Clubs, etc)");
		System.out.println("Full House: Any three-of-a-kind and any pair (I.E. Three Queens and Two 5's, Three 3's and Two Aces, etc)");
		System.out.println("Four-of-a-kind: As the name implies, four of the same face value cards (I.E. Four 2's, Four 6's, etc)");
		System.out.println("Straight Flush: A Straight with all cards from the same suit");
		System.out.println("Royal Straight Flush: A Straight Flush with cards 10 through Ace");
		System.out.println("");
		return;
	}

	//TODO: *BUG* Figure out why it reads an empty line when scanning for input
	//Allows the player to change the game settings
	public static void settings() {
		System.out.println("Current starting chip amount (Default: 1,000): " + chipSetting);
		System.out.println("Difficulty Guideline: 0 - Easy, 1 - Medium, 2 - Hard, 3 - Insane");
		System.out.println("Current CPU Difficulty level (Default: 0): " + difficulty);
		System.out.println("Current number of CPUs (Default: 3): " + numCPU);
		while (true) {
			System.out.println("To change the starting chip amount type: 'chips (amount)' where (amount) is the number of chips you want to start with.");
			System.out.println("To change the difficulty level type: 'difficulty (level)' where (level) is the number cooresponding to the level of difficulty.");
			System.out.println("To change the number of CPUs typs: 'cpu (number)' where number is how many computers you wish to play against.");
			System.out.println("To return to the menu type: 'return'");
			System.out.println("");
			String input = in.nextLine();
			System.out.println("input: '" + input + "'");
			if (input.contains("difficulty")) {
				String level = input.substring(11);
				try {
					int newLevel = Integer.parseInt(level);
					if (newLevel < 0 || newLevel > 3) System.out.println("I'm sorry, that wasnt a proper difficulty setting (-1 < difficulty < 4)");
					else difficulty = newLevel;
				} catch (Exception e) {
					System.out.println("I'm sorry, that wasnt a proper difficulty setting (-1 < difficulty < 4)");
				}
			}
			else if (input.contains("chips")) {
				String amount = input.substring(6);
				try {
					int newAmount = Integer.parseInt(amount);
					if (newAmount <= 0 || newAmount >= 10000000) System.out.println("I'm sorry, that wasnt a proper chip amount (0 < amount < 10,000,000)");
					else chipSetting = newAmount;
				} catch (Exception e) {
					System.out.println("I'm sorry, that wasnt a proper chip amount (0 < amount < 10,000,000)");
				}
			}
			else if (input.contains("cpu")) {
				String numCPU = input.substring(4);
				try {
					int newNumCPU = Integer.parseInt(numCPU);
					if (newNumCPU <= 0 || newNumCPU >= 8) System.out.println("I'm sorry, that wasnt a proper number of CPUs (0 < number < 8)");
					else Game.numCPU = newNumCPU;
				} catch (Exception e) {
					System.out.println("I'm sorry, that wasnt a proper number of CPUs (0 < number < 8)");
				}
				
			}
			else if (input.equals("return")) return;
			else System.out.println("I'm sorry, thats not a proper command.");
			System.out.println("");
		}
	}
	
	//Prints the menu and allows input to traverse options
	public static void startup() {
		Boolean check = false;
		int choice = 0;
		
		System.out.println("Welcome to Texas Hold'em!");
		System.out.println("Please enter a number cooresponding to an option.");
		System.out.println("1. Rules");
		System.out.println("2. Start Game");
		System.out.println("3. Settings");
		System.out.println("4. Exit");
		
		while (!check) {
			
			//Get input
			try {
				choice = in.nextInt();
				check = true;
			} catch (Exception e) {
				System.out.println("Improper Input");
				startup();
				return;
			}
		}
		
		//Switch based on input
		switch (choice) {
			case 1:
				rules();
				startup();
				break;
				
			case 2:
				initializeCPU();
				human.setNumChips(chipSetting);
				start();
				break;
				
			case 3:
				settings();
				
				startup();
				break;
				
			case 4:
				System.out.println("Good-Bye!");
				in.close();
				System.exit(0);
				break;
				
			default:
		}
		
		return;
	}
	
	//Closes down the program properly
	public static void shutdown() {
		System.out.println("Thanks for playing!");
		in.close();
	}
	
	public static void main(String args[]) {
		play = true;
		in = new Scanner(System.in);
		numCPU = 3;
		human = new Player();
		chipSetting = 1000;
		difficulty = 0;
		
		//Print start menu
		startup();

		while (play) {
			//Game has started and cards have been dealt to all players
			//Start the first round
			playFlop();
			
			//Start second round
			playTurn();
			
			//Start third round
			playRiver();
		}
		shutdown();
	}
}



class Card {
	int suit;
	int value;
	
	public int getSuit() { return suit; }
	
	public void setSuit(int set) { suit = set; }
	
	public int getValue() { return value; }
	
	public void setValue(int set) { value = set; }
}
