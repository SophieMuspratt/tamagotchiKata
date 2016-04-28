package tamagotchi;

import java.util.Scanner;
import java.util.Timer;

public class Tamagotchi {
	int hunger = 50;
	int fullness = 50;
	int happiness = 50;
	int tiredness = 50;
	
	public static void main(String [] args){
		Tamagotchi tamagotchi = new Tamagotchi();
		TempTask task = new TempTask(tamagotchi);
		Timer timer = new Timer();
		timer.schedule(task, 10000, 20000);
		tamagotchi.playTamagotchi();
	}

	private void continuePlayingTamagotchi(Scanner scan) {
		tamagotchiLevelsMessage();
		System.out.println("Would you like to continue?");
		System.out.println("Please enter one of the following:");
		System.out.println("|Yes|\t|No|");
		String YN = scan.nextLine();
		
		if(YN.equals("Yes") || YN.equals("yes") || YN.equals("Y") || YN.equals("y")){
			playTamagotchi();
		}
		else if (YN.equals("No") || YN.equals("no") || YN.equals("N") || YN.equals("n")){
			tamagotchiLevelsMessage();
			System.out.println("======== Goodbye For Now! =======");
			System.out.println("*********************************");
		}
		else{
			invalidYesNo(scan);
		}
	}

	private Scanner playTamagotchi() {
		Scanner scan = new Scanner(System.in);
		System.out.println("===========Tamagotchi============");
		tamagotchiLevelsMessage();
		System.out.println("Enter one of the following:");
		System.out.println("|Feed|\t|Play|\t|Bed|\t|Poop|");
		
		String command = scan.nextLine();
		String input = "";
		input = choiceValidation(command, input);
		
		switch (input){
		case "Feed": 
			feedTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		case "Play": 
			playWithTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		case "Bed": 
			bedTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		case "Poop": 
			poopTamagotchi();
			continuePlayingTamagotchi(scan);
			break;
		default:
			invalidCommand();
		}
		return scan;
	}

	private void invalidYesNo(Scanner scan) {
		System.out.println("Invalid Entry, Please Try Again");
		continuePlayingTamagotchi(scan);
	}

	private void invalidCommand() {
		System.out.println("Invalid Entry, Please Try Again");
		playTamagotchi();
	}

	public void poopTamagotchi() {
		if (fullness <=9){
			fullness = 0;
			
		}
		else if (fullness >= 10){
			fullness -= 10;
			System.out.println("========= Fullness Decreased!====");
			System.out.println("********* Fullness: " + fullness + "% *********");
			
		}
	}

	public void bedTamagotchi() {
		if (tiredness <=9){
			tiredness = 0;
			
		}
		else if (tiredness >= 10){
			tiredness -= 10;
			System.out.println("========= Tiredness Decreased!===");
			System.out.println("********* Tiredness: " + tiredness + "% ********");
			
		}
	}

	public void playWithTamagotchi() {
		if (happiness >=91){
			happiness = 100;
			
		}
		else if (happiness <= 90){
			happiness += 10;
			System.out.println("========= Happiness Increased!===");
			System.out.println("********* Happiness: " + happiness + "% ********");
		}
		if (tiredness >=91){
			tiredness = 100;
			
		}
		else if (tiredness <= 90){
			tiredness += 10;
			System.out.println("========= Tiredness Increased!===");
			System.out.println("********* Tiredness: " + tiredness + "% ********");
			
		}
	}

	public void feedTamagotchi() {
		if (hunger <=9){
			hunger = 0;
		}
		else if (hunger >= 10){
			hunger -= 10;
			System.out.println("========= Hunger Decreased!======");
			System.out.println("********* Hunger: " + hunger + "% ***********");
		}
		if (fullness >=91){
			fullness = 100;
		}
		else if (fullness <= 90){
			fullness += 10;
			System.out.println("========= Fullness Increase======");
			System.out.println("********* Fullness: " + fullness + "% *********");
		}
	}
	
	private void tamagotchiLevelsMessage(){
		System.out.println("********* Hunger: " + hunger + "% ***********");
		System.out.println("********* Fullness: " + fullness + "% *********");
		System.out.println("********* Happiness: " + happiness + "% ********");
		System.out.println("********* Tiredness: " + tiredness + "% ********");
		System.out.println("*********************************");
	}
	
	public void tamagotchiTimer(){
		if (hunger >=97){
			hunger = 100;
		}
		else if (hunger <= 96){
			hunger += 4;
		}
		
		if (fullness <=1){
			fullness = 0;			
		}
		else if (fullness >= 2){
			fullness -= 2;
		}
		if (happiness <=1){
			happiness = 0;			
		}
		else if (happiness >= 2){
			happiness -= 2;
		}
		if (tiredness >=97){
			tiredness = 100;
		}
		else if (tiredness <= 96){
			tiredness += 4;
		}
	
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
	
	
	private static String choiceValidation(String command, String input) {
		if (command.equals("Feed") || command.equals("feed")){
			input = "Feed";
		}
		else if (command.equals("Play") || command.equals("play")){
			input = "Play";
		}
		else if (command.equals("Bed") || command.equals("bed")){
			input = "Bed";
		}
		else if (command.equals("Poop") || command.equals("poop")){
			input = "Poop";
		}
		return input;
	}	

}
