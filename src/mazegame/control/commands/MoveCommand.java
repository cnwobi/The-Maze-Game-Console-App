package mazegame.control.commands;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Exit;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;
import mazegame.utility.DiceRoller;

public class MoveCommand implements Command {
    private DiceRoller diceRoller = DiceRoller.getInstance();
    IMazeClient gameClient = new SimpleConsoleClient();

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        /*thePlayer.getCurrentLocation().*/
        if (userInput.getArguments().size() == 0) {
            if (userInput.getCommand().equals("flee")) {
                thePlayer.setCurrentLocation(thePlayer.getLastLocation());
                return new CommandResponse("You successfully fled back to " + thePlayer.getCurrentLocation().getLabel());
            }
            return new CommandResponse("If you want to move you need to tell me where.");
        }
        String exitLabel = (String) userInput.getArguments().get(0);
        Exit desiredExit = thePlayer.getCurrentLocation().getExit(exitLabel);
        if (desiredExit == null) {

            return new CommandResponse("There is no exit there . . . try moving somewhere else!");
        }
        if (desiredExit.isLocked()) {
            return new CommandResponse("This exit is locked please...acquire the ITECH 3215 banner to proceed");
        }
        thePlayer.setCurrentLocation(desiredExit.getDestination());
       for(NonPlayerCharacter npc: thePlayer.getCurrentLocation().getNonPlayerCharacters().values()){
            if(npc.getHostile() == true){
                gameClient.playerMessage("**** Hostile Characters in location****\n****Attack & Flee Command activated****\n" +
                        npc.getName() + " has attacked you\n" + npc.getName() + " is rolling an attack");
                gameClient.getReply("\n<<Hit enter to continue>>");
                int lifePointB4Attack = thePlayer.getLifePoints();
                //int attackRoll = diceRoller.generateAbilityScore(20,1);
                int attackRoll = diceRoller.generateAbilityScore(npc.getWeapon().getDiceFace(), npc.getWeapon().getNumberOfRolls());
                thePlayer.setLifePoints(thePlayer.getLifePoints() - attackRoll);
                System.out.println("Attack Roll: " + attackRoll);
                gameClient.playerMessage("Your life point before attack was " + lifePointB4Attack + ",and you lost " + attackRoll + "\nYour remain lifepoints are :" + thePlayer.getLifePoints());
                gameClient.getReply("\n<<Hit enter to continue>>");
                 break;
            }
        }
        return new CommandResponse("You successfully moved ");// + exitLabel + " and find   yourself somewhere else\n\n" + thePlayer.getCurrentLocation().toString());
    }
}

