package mazegame.utility;

import java.util.ArrayList;
import java.util.Collections;

import mazegame.entity.Dice;

public class DiceRoller {
	private static DiceRoller instance  = new DiceRoller();
	private Dice d6;

	private DiceRoller () {
		d6 = new Dice (6);
	}
	
	public static DiceRoller getInstance () {
		return instance;
	}
	
	public int generateAbilityScore (int faces,int numberOfRolls) {
		d6.setFaces(faces);
		ArrayList<Integer> results = new ArrayList<Integer> ();
		for (int i = 0; i < numberOfRolls+9; i++) {
			results.add(d6.roll());
		}
		
		Collections.sort(results);
		int sum = 0;
		for (int i = 0; i < numberOfRolls; i++) {
			sum += results.get(i);
		}
		return sum;
	}

}
