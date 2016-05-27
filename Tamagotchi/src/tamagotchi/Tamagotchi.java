package tamagotchi;

import java.util.Scanner;
import java.util.Timer;

public class Tamagotchi {
	private static final int START_VALUE = 50;
	private static final int CHANGE_VALUE = 10;
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 100;
	int hunger = START_VALUE;
	int fullness = START_VALUE;
	int happiness = START_VALUE;
	int tiredness = START_VALUE;
	
	public static void main(String [] args){
		Tamagotchi tamagotchi = new Tamagotchi();
		TempTask task = new TempTask(tamagotchi);
		Timer timer = new Timer();
		timer.schedule(task, 10000, 20000);
		tamagotchi.playTamagotchi();
	}
	
	private Scanner playTamagotchi() {
		Scanner scan = new Scanner(System.in);
		System.out.println("===========Tamagotchi============");
		tamagotchiLevelsMessage();
		System.out.println("Enter one of the following:");
		System.out.println("|Feed|\t|Play|\t|Bed|\t|Poop|");
		
		String command = getUserInput(scan);

		switch (command){
		case "feed": 
			feedTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		case "play": 
			playWithTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		case "bed": 
			bedTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		case "poop": 
			poopTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		default:
			invalidCommand();
		}
		System.out.println("EXIT");
		return scan;
	}

	private String getUserInput(Scanner scan) {
		String command = scan.nextLine();
		choiceValidation(command);
		return command.toLowerCase();
	}
	
	private boolean choiceValidation(String command) {
		if (command.equals("feed")){
			return true;
		}
		else if (command.equals("play")){
			return true;
		}
		else if (command.equals("bed")){
			return true;
		}
		else if (command.equals("poop")){
			return true;
		}
		return false;
	}	
	
	public void feedTamagotchi() {
		hunger = decreaseLevel(hunger);
		fullness = increaseLevel(fullness);
	}

	public void playWithTamagotchi() {
		tiredness = increaseLevel(tiredness);
		happiness = increaseLevel(happiness);
	}
	
	public void bedTamagotchi() {
		tiredness = decreaseLevel(tiredness);
	}
	
	public void poopTamagotchi() {
		fullness = decreaseLevel(fullness);
	}
	
	public int increaseLevel(int value, int changeValue){
		value += changeValue;
		if (value > MAX_VALUE){
			value = MAX_VALUE;
		}
		return value;
	}
	
	private int increaseLevel(int value) {
		return increaseLevel(value, CHANGE_VALUE);
	}
	
	private int decreaseLevel(int value, int changeValue) {
		value -= changeValue;
		if (value < MIN_VALUE){
			value = MIN_VALUE;
		}
		return value;
	}

	private int decreaseLevel(int value) {
		return decreaseLevel(value, CHANGE_VALUE);
	}

	private void continuePlayingTamagotchi(Scanner scan) {
		tamagotchiLevelsMessage();
		System.out.println("Would you like to continue?");
		System.out.println("Please enter one of the following:");
		System.out.println("|Yes|\t|No|");
		String YN = scan.nextLine();
		
		if(YN.toLowerCase().equals("yes") || YN.toLowerCase().equals("y")){
			playTamagotchi();
		}
		else if (YN.toLowerCase().equals("no") || YN.toLowerCase().equals("n")){
			tamagotchiLevelsMessage();
			System.out.println("======== Goodbye For Now! =======");
			System.out.println("*********************************");
		}
		else{
			invalidYesNo(scan);
		}
	}

	private void invalidYesNo(Scanner scan) {
		System.out.println("Invalid Entry, Please Try Again");
		continuePlayingTamagotchi(scan);
	}

	private void invalidCommand() {
		System.out.println("Invalid Entry, Please Try Again");
		playTamagotchi();
	}

	private void tamagotchiLevelsMessage(){
		System.out.println("********* Hunger: " + hunger + "% ***********");
		System.out.println("********* Fullness: " + fullness + "% *********");
		System.out.println("********* Happiness: " + happiness + "% ********");
		System.out.println("********* Tiredness: " + tiredness + "% ********");
		System.out.println("*********************************");
	}
	
	public void tamagotchiTimer(){
		hunger = increaseLevel(hunger, 4);
		fullness = decreaseLevel(fullness, 2);
		happiness = decreaseLevel(happiness, 2);
		tiredness = increaseLevel(tiredness, 4);

	
		System.out.println("=========Timer Levels===========");
		tamagotchiLevelsMessage();
		
		if (hunger == 100 && tiredness == 100){
			System.out.println("*********************************");
			System.out.println("******Your Tamagotchi Died!******");
			System.out.println("*********************************");
			System.exit(0);
		}
		
	}
	
	public int getHunger() {
		return hunger;
	}
	public int getFullness(){
		return fullness;
	}
	public int getHappiness(){
		return happiness;
	}
	public int getTiredness(){
		return tiredness;
	}
}
