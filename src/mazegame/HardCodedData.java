package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.*;
import mazegame.utility.*;

public class HardCodedData implements IMazeData {
	private Location startUp;
	private WeightLimit weightLimit = WeightLimit.getInstance();
	private WeaponTable weapons = WeaponTable.getInstance();
	private ArmorTable armors = ArmorTable.getInstance();
	
	public HardCodedData()
	{

		populateAgilityTable();
		populateWeightLimitTable();
		populateStrengthTable();
		populateWeaponsTable();
		populateArmorTable();
        createLocations();
	}
	
	public Location getStartingLocation()
	{
		return startUp;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the Mount Helanous";
	}
	
	private void createLocations ()
	{
		startUp = new Location ("a clearing surrounded by a dark, menacing looking forest", "Rebel Base");
		Location drawBridge = new Location ("a drawbridge leading to Gregor's Castle...guarded by his minions", "Drawbridge");
		Location gregorsCastle = new Location ("a terrifying large castle where the evil Gregor lives", "Gregor's Castle");
		Location blackSmith = new Blacksmith ("a place where godly weapons are forged", "Blacksmith");
		Location innOfTheBoat = new Location("a place to drink and merry **beware Philip and his gang visit here too**","Inn of the boat");
		Location alliedBase = new Location ("a place where warriors that hate Gregor reside...**make new friends to kill Gregor here***","Allied base");
		
		// Connect Locations
		startUp.addExit("north",  new Exit ("you see a drawbridge leading to Gregor's Castle...guarded by his minions to the north", drawBridge));
		drawBridge.addExit("south", new Exit("you see a clearing surrounded by a dark, menacing looking forest to the south", startUp));

        startUp.addExit("east", new Exit("you see a  place where godly weapons are forged to the east", blackSmith));
        blackSmith.addExit("west", new Exit("you see a clearing surrounded by a dark, menacing looking forest to the west", startUp));

        startUp.addExit("south",new Exit("you see a place to drink and merry **beware Philip and his gang visit here too**",innOfTheBoat));
        innOfTheBoat.addExit("north", new Exit("a clearing surrounded by a dark, menacing looking forest",startUp)) ;

        startUp.addExit("west",new Exit("you see a place where warriors that hate Gregor reside to the west",alliedBase));
        alliedBase.addExit("east",new Exit("you see a clearing surrounded by a dark, menacing looking forest to the east",startUp));


        //add location characters
         startUp.addNonPlayerCharacters("chukas",new NonPlayerCharacter("Chuka",20,21,10,false));
        drawBridge.addNonPlayerCharacters("philip",new NonPlayerCharacter("philip",20,21,10,true,(Weapon)weapons.getWeapon("falchion")));
        drawBridge.addNonPlayerCharacters("hacka",new NonPlayerCharacter("hacka",19,7,13,true,(Weapon)weapons.getWeapon("falchion")));
        drawBridge.addNonPlayerCharacters("troy",new NonPlayerCharacter("troy",19,7,13,true,(Weapon)weapons.getWeapon("falchion")));
         // add location items
       // startUp.addItems("sword-bastard", new Weapon("sword-bastard",1000,390,"a  large sword designed to be used primarily with two hands"));
        startUp.addItems("battleaxe",new Weapon("battleaxe",10,7,"a large broad-bladed axe used in ancient warfare.",8,1));
        startUp.addItems("dagger",(Item)weapons.getWeapon("dagger"));
        startUp.addItems("life",new Collectible("life",10));
        blackSmith.addItems("falchion", (Item) weapons.getWeapon("falchion"));
        blackSmith.addItems("nunchaku",(Item) weapons.getWeapon("nunchaku"));
        blackSmith.addItems("padded",(Item) armors.getArmor("padded"));
        blackSmith.addItems("leather",(Item) armors.getArmor("leather"));
        /*blackSmith.addItems("sword-bastard", new Weapon("sword-bastard",1000,390,"a  large sword designed to be used primarily with two hands"));
        blackSmith.addItems("battleaxe",new Weapon("battleaxe",10,7,"a large broad-bladed axe used in ancient warfare."));
******* add dice face and number of roles later
*/

     alliedBase.addExit("northwest",new Exit("you see a drawbridge leading to Gregor's Castle...guarded by his minions to the northwest",drawBridge));
    drawBridge.addExit("southeast",new Exit("you see a place where warriors that hate Gregor reside to the southeast",alliedBase));


        gregorsCastle.addExit("south", new Exit("you see a you see a drawbridge that lead you to Gregor's Castle... to the south", drawBridge));
       drawBridge.addExit("north", new Exit("you see a terrifying large castle where the evil Gregor lives to the north", gregorsCastle,true));

        drawBridge.addExit("southwest", new Exit("you see a  place where godly weapons are forged to the southwest", blackSmith));
        blackSmith.addExit("northeast", new Exit("yyou see a you see a drawbridge that lead you to Gregor's Castle...  to the northeast", drawBridge));

	}
    private void populateStrengthTable()
    {
        StrengthTable strengthModifiers = StrengthTable.getInstance();
        strengthModifiers.setModifier(1, -5);
        strengthModifiers.setModifier(2, -4);
        strengthModifiers.setModifier(3, -4);
        strengthModifiers.setModifier(4, -3);
        strengthModifiers.setModifier(5, -3);
        strengthModifiers.setModifier(6, -2);
        strengthModifiers.setModifier(7, -2);
        strengthModifiers.setModifier(8, -1);
        strengthModifiers.setModifier(9, -1);
        strengthModifiers.setModifier(10, 0);
        strengthModifiers.setModifier(11, 0);
        strengthModifiers.setModifier(12, 1);
        strengthModifiers.setModifier(13, 1);
        strengthModifiers.setModifier(14, 2);
        strengthModifiers.setModifier(15, 2);
        strengthModifiers.setModifier(16, 3);
        strengthModifiers.setModifier(17, 3);
        strengthModifiers.setModifier(18, 4);
        strengthModifiers.setModifier(19, 4);
        strengthModifiers.setModifier(20, 5);
        strengthModifiers.setModifier(21, 5);
        strengthModifiers.setModifier(22, 5);
        strengthModifiers.setModifier(23, 5);
        strengthModifiers.setModifier(24, 5);
        strengthModifiers.setModifier(25, 5);
        strengthModifiers.setModifier(26, 8);
        strengthModifiers.setModifier(27, 8);
        strengthModifiers.setModifier(28, 8);
        strengthModifiers.setModifier(29, 8);
        strengthModifiers.setModifier(30, 10);
        strengthModifiers.setModifier(31, 10);
        strengthModifiers.setModifier(32, 10);
        strengthModifiers.setModifier(33, 10);
        strengthModifiers.setModifier(34, 10);
        strengthModifiers.setModifier(35, 10);
        strengthModifiers.setModifier(36, 12);
        strengthModifiers.setModifier(37, 12);
        strengthModifiers.setModifier(38, 12);
        strengthModifiers.setModifier(39, 12);
        strengthModifiers.setModifier(40, 12);
        strengthModifiers.setModifier(41, 15);
        strengthModifiers.setModifier(42, 15);
        strengthModifiers.setModifier(43, 15);
        strengthModifiers.setModifier(44, 17);
        strengthModifiers.setModifier(45, 17);
        strengthModifiers.setModifier(46, 18);
    }

    private void populateAgilityTable()
    {
        AgilityTable agilityModifiers = AgilityTable.getInstance();
        agilityModifiers.setModifier(1, -5);
        agilityModifiers.setModifier(2, -5);
        agilityModifiers.setModifier(3, -5);
        agilityModifiers.setModifier(4, -3);
        agilityModifiers.setModifier(5, -3);
        agilityModifiers.setModifier(6, -2);
        agilityModifiers.setModifier(7, -2);
        agilityModifiers.setModifier(8, -1);
        agilityModifiers.setModifier(9, -1);
        agilityModifiers.setModifier(10, 0);
        agilityModifiers.setModifier(11, 0);
        agilityModifiers.setModifier(12, 1);
        agilityModifiers.setModifier(13, 1);
        agilityModifiers.setModifier(14, 2);
        agilityModifiers.setModifier(15, 2);
        agilityModifiers.setModifier(16, 3);
        agilityModifiers.setModifier(17, 3);
        agilityModifiers.setModifier(18, 4);
        agilityModifiers.setModifier(19, 4);
        agilityModifiers.setModifier(20, 6);
        agilityModifiers.setModifier(21, 6);
        agilityModifiers.setModifier(22, 6);
        agilityModifiers.setModifier(23, 6);
        agilityModifiers.setModifier(24, 6);
        agilityModifiers.setModifier(25, 6);
        agilityModifiers.setModifier(26, 8);
        agilityModifiers.setModifier(27, 8);
        agilityModifiers.setModifier(28, 8);
        agilityModifiers.setModifier(29, 8);
        agilityModifiers.setModifier(30, 8);
        agilityModifiers.setModifier(31, 8);
        agilityModifiers.setModifier(32, 11);
        agilityModifiers.setModifier(33, 11);
        agilityModifiers.setModifier(34, 11);
        agilityModifiers.setModifier(35, 11);
        agilityModifiers.setModifier(36, 11);
        agilityModifiers.setModifier(37, 11);
        agilityModifiers.setModifier(38, 13);
        agilityModifiers.setModifier(39, 13);
        agilityModifiers.setModifier(40, 13);
        agilityModifiers.setModifier(41, 13);
        agilityModifiers.setModifier(42, 13);
        agilityModifiers.setModifier(43, 13);
        agilityModifiers.setModifier(44, 15);
        agilityModifiers.setModifier(45, 15);
        agilityModifiers.setModifier(46, 15);
    }

    private void populateWeightLimitTable()
    {
        Dice dice = new Dice(20);
        System.out.println("Dice roll *****************"+dice.roll());
        WeightLimit weightModifier = WeightLimit.getInstance();
        weightModifier.setModifier(1, 6);
        weightModifier.setModifier(2, 13);
        weightModifier.setModifier(3, 20);
        weightModifier.setModifier(4, 26);
        weightModifier.setModifier(5, 33);
        weightModifier.setModifier(6, 40);
        weightModifier.setModifier(7, 46);
        weightModifier.setModifier(8, 53);
        weightModifier.setModifier(9, 60);
        weightModifier.setModifier(10, 66);
        weightModifier.setModifier(11, 76);
        weightModifier.setModifier(12, 86);
        weightModifier.setModifier(13, 100);
        weightModifier.setModifier(14, 116);
        weightModifier.setModifier(15, 133);
        weightModifier.setModifier(16, 153);
        weightModifier.setModifier(17, 173);
        weightModifier.setModifier(18, 200);
        weightModifier.setModifier(19, 233);
        weightModifier.setModifier(20, 266);
        weightModifier.setModifier(21, 306);
        weightModifier.setModifier(22, 346);
        weightModifier.setModifier(23, 400);
        weightModifier.setModifier(24, 466);
        weightModifier.setModifier(25, 533);
        weightModifier.setModifier(26, 613);
        weightModifier.setModifier(27, 693);
        weightModifier.setModifier(28, 800);
        weightModifier.setModifier(29, 933);
        weightModifier.setModifier(30, 1013);
        weightModifier.setModifier(31, 1093);
        weightModifier.setModifier(32, 1300);
        weightModifier.setModifier(33, 1433);
        weightModifier.setModifier(34, 1513);
        weightModifier.setModifier(35, 1593);
        weightModifier.setModifier(36, 1700);
        weightModifier.setModifier(37, 1833);
        weightModifier.setModifier(38, 1913);
        weightModifier.setModifier(39, 1993);
        weightModifier.setModifier(40, 2100);
        weightModifier.setModifier(41, 2233);
        weightModifier.setModifier(42, 2313);
        weightModifier.setModifier(43, 2393);
        weightModifier.setModifier(44, 2500);
        weightModifier.setModifier(45, 2633);
        weightModifier.setModifier(46, 2713);
    }

    public void populateWeaponsTable(){
        WeaponTable weaponTable = WeaponTable.getInstance();
        weaponTable.setWeapon("dagger",new Weapon("dagger",170,2,"a short knife with a pointed and edged blade, used as a weapon.",4,1));
        weaponTable.setWeapon("nunchaku",new Weapon("nunchaku",1,2,"I dont know",6,1));
        weaponTable.setWeapon("greatClub",new Weapon("greatClub",2,10,"blank",10,1));
        weaponTable.setWeapon("falchion",new Weapon("falchion",75,15,"a one-handed, single-edged sword of European origin, whose design is reminiscent of the Chinese dadao, and modern machete. ",4,2));
    }
    public void populateArmorTable(){
        ArmorTable armorTable = ArmorTable.getInstance();
        armorTable.setArmor("padded",new Armor("padded",5,1,10));
        armorTable.setArmor("leather",new Armor("leather",10,2,15));
        armorTable.setArmor("studded leather",new Armor("studded leather",25,4,20));
    }
}
