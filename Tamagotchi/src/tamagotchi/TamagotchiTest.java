package tamagotchi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TamagotchiTest {
	
	Tamagotchi game;
	
	@Before
	public void setUp(){
		 game = new Tamagotchi();
	}

	@Test
	public void feedTamagotchiToIncreaseFulnessAndDecreaseHunger() {
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
	
	@Test
	public void feedTamagotchiToTestBoundaries() {
		game.feedTamagotchi();
		game.feedTamagotchi();
		game.feedTamagotchi();
		game.feedTamagotchi();
		game.feedTamagotchi();
		game.feedTamagotchi();
		
		assertEquals(0, game.getHunger());
		assertEquals(100, game.getFullness());
	} 
	
	@Test
	public void playTamagotchiToTestBoundaries() {
		game.playWithTamagotchi();
		game.playWithTamagotchi();
		game.playWithTamagotchi();
		game.playWithTamagotchi();
		game.playWithTamagotchi();
		game.playWithTamagotchi();
		
		assertEquals(100, game.getHappiness());
		assertEquals(100, game.getTiredness());
	}
	
	
	@Test
	public void sleepTamagotchiToTestBoundaries() {
		game.bedTamagotchi();
		game.bedTamagotchi();
		game.bedTamagotchi();
		game.bedTamagotchi();
		game.bedTamagotchi();
		game.bedTamagotchi();
		
		assertEquals(0, game.getTiredness());
	}
	
	@Test
	public void makeTamagotchiPoopToTestBoundaries() {
		game.poopTamagotchi();
		game.poopTamagotchi();
		game.poopTamagotchi();
		game.poopTamagotchi();
		game.poopTamagotchi();
		game.poopTamagotchi();
		
		assertEquals(0, game.getFullness());

	}
	


	

}
