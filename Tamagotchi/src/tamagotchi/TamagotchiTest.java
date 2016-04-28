package tamagotchi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TamagotchiTest {
//	static int hunger = 100;
//	static int fullness = 50;
//	static int happiness = 50;
//	static int tiredness = 25;
	
	Tamagotchi game;
	
	@Before
	public void setUp(){
		 game = new Tamagotchi();
	}

	
	
	@Test
	public void feedTamagotchiToIncreaseFulnessAndDecreaseHunger() {
//		game.setHunger(19);
		game.feedTamagotchi();
		
		assertEquals(40, game.getHunger());
		assertEquals(60, game.getFullness());
	} 
	
	@Test
	public void playTamagotchiToIncreaseHappinessAndTiredness() {
		game.playWithTamagotchi();
		
		assertEquals(60, game.getHappiness());
		assertEquals(60, game.getTiredness());
	}
	
	
	@Test
	public void putTamagotchiToBedToDecreaseTiredness() {
		game.bedTamagotchi();
		
		assertEquals(40, game.getTiredness());
	}
	
	@Test
	public void makeTamagotchiPoopToDecreaseFullness() {
		game.poopTamagotchi();
		
		assertEquals(40, game.getFullness());

	}
	


	

}
