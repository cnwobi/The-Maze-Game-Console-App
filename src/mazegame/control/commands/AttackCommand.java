package mazegame.control.commands;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Location;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;
import mazegame.utility.DiceRoller;
import mazegame.utility.StrengthTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AttackCommand implements Command {
    private Random random;
    private List<String> keys;
    private String randomKey;
    private NonPlayerCharacter nonPlayerCharacter;
    private DiceRoller diceRoller = DiceRoller.getInstance();
    private StrengthTable strengthTable = StrengthTable.getInstance();
     /*DiceRoller diceRoller = DiceRoller.getInstance();
        int attackRoll = diceRoller.generateAbilityScore(20,1);
        System.out.println("Ability Score: "+attackRoll);*/

    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        IMazeClient gameClient = new SimpleConsoleClient();
        HashMap<String,NonPlayerCharacter> nonPlayerCharacterHashMap = thePlayer.getCurrentLocation().getNonPlayerCharacters();
       random = new Random();
       keys = new ArrayList<>(nonPlayerCharacterHashMap.keySet());
       randomKey=keys.get(random.nextInt(keys.size()));
       nonPlayerCharacter = nonPlayerCharacterHashMap.get(randomKey);
       gameClient.playerMessage("Attacking "+nonPlayerCharacter.getName());
       int AChit = diceRoller.generateAbilityScore(20,1) +strengthTable.getModifier(thePlayer.getStrength());
       if (AChit>2) {

       }


        return new CommandResponse ("\nYou entered the attack command");
    }
}
