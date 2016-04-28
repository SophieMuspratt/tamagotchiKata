package tamagotchi;

import java.util.TimerTask;

public class TempTask extends TimerTask {

	private Tamagotchi tamagotchi;
	
	public TempTask(Tamagotchi tamagotchi) {
		this.tamagotchi = tamagotchi;
	}
	
	@Override
	public void run() {
		tamagotchi.tamagotchiTimer();
	}

}
