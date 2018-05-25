package mazegame.control.commands;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;
import mazegame.utility.AgilityTable;
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
    private AgilityTable agilityTable = AgilityTable.getInstance();
     /*private DiceRoller diceRoller = DiceRoller.getInstance();
        int attackRoll = diceRoller.generateAbilityScore(20,1);
        System.out.println("Ability Score: "+attackRoll);*/
     private int globalLifeB4Attack;
     private int globalAttackRoll;

    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        IMazeClient gameClient = new SimpleConsoleClient();
        HashMap<String,NonPlayerCharacter> nonPlayerCharacterHashMap = thePlayer.getCurrentLocation().getNonPlayerCharacters();
       random = new Random();
       keys = new ArrayList<>(nonPlayerCharacterHashMap.keySet());

       randomKey=keys.get(random.nextInt(keys.size()));

       nonPlayerCharacter = nonPlayerCharacterHashMap.get(randomKey);

       gameClient.playerMessage("Attacking "+nonPlayerCharacter.getName());

       int AcHit = diceRoller.generateAbilityScore(20,1) +strengthTable.getModifier(thePlayer.getStrength());

       int armorClass = 10 + nonPlayerCharacter.getArmor().getBonus()+ agilityTable.getModifier(nonPlayerCharacter.getAgility());

       gameClient.playerMessage("\nAcHit: "+AcHit+"\narmorClass: "+armorClass);


       if (AcHit >= armorClass) {
           if (thePlayer.getEquippedWeapon().size()==0){
               return new CommandResponse("\nYou have not equipped any weapon for the battle---*****Flee*****");
           }
           int diceFace = thePlayer.getEquippedWeapon().get(0).getDiceFace();

           int numberOfRolls=thePlayer.getEquippedWeapon().get(0).getNumberOfRolls();

           int attackRoll = diceRoller.generateAbilityScore(diceFace,numberOfRolls);

           gameClient.playerMessage("\n---You successfully registered a hit---\n ");
           gameClient.playerMessage("------analysing damage-----");
           gameClient.getReply("\n<<Hit enter to continue>>");

           nonPlayerCharacter.setLifePoints(nonPlayerCharacter.getLifePoints()-attackRoll);


           if(nonPlayerCharacter.getLifePoints()<=0){
               String deadCharacter = nonPlayerCharacter.getName();
               nonPlayerCharacterHashMap.remove(nonPlayerCharacter.getName());
               return new CommandResponse("---You Killed "+ deadCharacter+"---");
           }



           /*return new CommandResponse("\n---Attack Complete----\n********************************\nAttacked: ["+nonPlayerCharacter.getName()+"]\n********************************\n" +
                   "Damage to "+nonPlayerCharacter.getName()+":: -"+attackRoll+"\n********************************\n"+nonPlayerCharacter.getName()+"'s " +
                   "remaining lifepoints :: "+nonPlayerCharacter.getLifePoints());*/
           gameClient.playerMessage("\n---Attack Complete----\n********************************\nAttacked: ["+nonPlayerCharacter.getName()+"]\n********************************\n" +
                   "Damage to "+nonPlayerCharacter.getName()+":: -"+attackRoll+"\n********************************\n"+nonPlayerCharacter.getName()+"'s " +
                   "remaining lifepoints :: "+nonPlayerCharacter.getLifePoints());
       }
       gameClient.playerMessage("\n*********"+nonPlayerCharacter.getName()+" is attacking you*******");
       gameClient.playerMessage("\n------"+nonPlayerCharacter.getName()+" is rolling the dice for attack-----");
        int npcAttackRoll = diceRoller.generateAbilityScore(20,1) + strengthTable.getModifier(nonPlayerCharacter.getStrength());
        int defaultPlayerArmorClass=10 + agilityTable.getModifier(thePlayer.getAgility());
        int playerArmorClass=0;



            if (thePlayer.getEquippedShield().size()==0 && thePlayer.getEquippedArmor().size() != 0) {
                gameClient.playerMessage("Warning!!!!! You have not equipped any shield");
                playerArmorClass =  thePlayer.getEquippedArmor().get(0).getBonus();
            }
            else if (thePlayer.getEquippedArmor().size()==0 && thePlayer.getEquippedShield().size() !=0){
                gameClient.playerMessage("Warning!!!!! You have not equipped any armor");
                playerArmorClass =  thePlayer.getEquippedShield().get(0).getBonus();
            }
            else if (thePlayer.getEquippedArmor().size() ==0 && thePlayer.getEquippedShield().size()==0){
                gameClient.playerMessage("\nWarning!!!!!!!! you have not equipped any shield nor armor\n");


            }
            else {
                playerArmorClass = thePlayer.getEquippedArmor().get(0).getBonus()+thePlayer.getEquippedShield().get(0).getBonus();
            }
            int overall = playerArmorClass+defaultPlayerArmorClass;

       if(npcAttackRoll >= overall) {
           gameClient.playerMessage(nonPlayerCharacter.getName() + " registered a hit and is now rolling for an attack");
           /*
            * Roll an attack using the diceRoller and passing the npc weapons (dice faces and number of rolls) ---please see weapon table
            * documentation*/
           int attackRoll = diceRoller.generateAbilityScore(nonPlayerCharacter.getWeapon().getDiceFace(), nonPlayerCharacter.getWeapon().getNumberOfRolls());
          this.globalLifeB4Attack = thePlayer.getLifePoints();
          globalAttackRoll = attackRoll;
          gameClient.playerMessage("attackRoll: " +attackRoll+" globalLifeAttackRoll: "+globalLifeB4Attack+" globalAttachRoll: "+globalAttackRoll);
           thePlayer.setLifePoints(thePlayer.getLifePoints() - attackRoll);

           if (thePlayer.getLifePoints() <= 0) {
               gameClient.playerMessage("---You have been killed by " + nonPlayerCharacter.getName());
               return new CommandResponse("---You have been killed by " + nonPlayerCharacter.getName(), true);
           }
       }

           return new CommandResponse("---Attack Complete---\n You life point before attack :"+globalLifeB4Attack+"\n Your " +
                   "Life point after attack: "+ thePlayer.getLifePoints()+"\nNPC Attack Roll : "+globalAttackRoll);


    }
}
