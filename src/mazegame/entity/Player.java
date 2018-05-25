package mazegame.entity;

import mazegame.utility.WeightLimit;

import java.util.ArrayList;

public class Player extends Character {
	
	private Location currentLocation;
	private Location lastLocation;
    private String equippedShieldName;
    private  String equippedArmorName;
    private String equippedWeaponName;

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }

    private static Player instance = null;
	private int weightLimit;
	private Inventory playerInventory;
    private WeightLimit weightModifier = WeightLimit.getInstance();
    private ArrayList<Weapon> equippedWeapon;
    private ArrayList<Shield> equippedShield;
    private ArrayList<Armor>  equippedArmor;

    private Player()
    {
    }

    private Player(String name, int strength,int agility, int lifepoints)
	{

	    super (name);
	   super.setStrength(strength);
	   super.setAgility(agility);
	   super.setLifePoints(lifepoints);
       weightLimit = weightModifier.getModifier(super.getStrength()); //use weight modifier to get weight limit according to character strength
        playerInventory = new Inventory();
        playerInventory.getGold().Add(150);
        weightLimit -=playerInventory.getGold().getWeight();
        equippedWeapon = new ArrayList<>();
        equippedArmor = new ArrayList<>();
        equippedShield = new ArrayList<>();
	}


	public static Player getInstance(String name,int strength,int agility, int lifepoints){
        if(instance== null)
            instance = new Player(name,strength,agility,lifepoints);
        return instance;

    }
public int getWeightLimit() {

        return weightLimit;
    }

    public void setWeightLimit(int weight) {

        this.weightLimit = weight;
    }



    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        lastLocation = this.currentLocation;
        this.currentLocation = currentLocation;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }


    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public void setLifePoints(int lifePoints) {

        super.setLifePoints(lifePoints);
    }

    public void setStrength(int strength) {
       super.setStrength(strength);
    }

    @Override
    public int getLifePoints() {
        return super.getLifePoints();
    }

    @Override
    public int getAgility() {
        return super.getAgility();
    }

   public String equipWeapon(Weapon weapon){

        if (equippedWeapon.size() ==0){
            equippedWeapon.add(weapon);
            return "You successfully equipped weapon[" +equippedWeapon.get(0).getLabel() + "]";
        }
        else if (equippedWeapon.get(0) == weapon){
            return "["+equippedWeapon.get(0).getLabel() +"] is already equipped";
        }
       else
            return "You cannot equip more than one weapon at a time....unequip [" + equippedWeapon.get(0).getLabel() + "] before equipping ["+weapon.getLabel()+"]";

   }
    public String equipArmor(Armor armor) {


            if (equippedArmor.size() == 0) {
                equippedArmor.add(armor);
                return "You successfully equipped armor [" + equippedArmor.get(0).getLabel() + "]";
            } else if (equippedArmor.get(0) == armor) {
                return "[" + equippedArmor.get(0).getLabel() + "] is already equipped";
            } else
                return "You cannot equip more than one armor at a time....unequip [" + equippedArmor.get(0).getLabel() + "] before equipping [" + armor.getLabel() + "]";


    }
    public String equipShield(Shield shield){

        if (equippedShield.size() ==0){
            equippedShield.add(shield);
            return "You successfully equipped shield [" +equippedShield.get(0).getLabel() + "]";
        }
        else if (equippedShield.get(0) == shield){
            return "["+equippedShield.get(0).getLabel() +"] is already equipped";
        }
        else
            return "You cannot equip more than one shield at a time....unequip [" + equippedShield.get(0).getLabel() + "] before equipping ["+shield.getLabel()+"]";

    }
    public ArrayList<Weapon> getEquippedWeapon() {
        return equippedWeapon;
    }
    public ArrayList<Armor> getEquippedArmor(){
        return equippedArmor;
    }

    public ArrayList<Shield> getEquippedShield() {
        return equippedShield;
    }

    public void setEquipped(ArrayList<Weapon> equipped) {
        this.equippedWeapon = equipped;
    }

    @Override
    public String restorLifePoints(int lifePoints) {
        return super.restorLifePoints(lifePoints);
    }

    public String getEquippedShieldName() {
        if (equippedShield.size()==0){
            equippedShieldName= "None";

        }
        else {
            equippedShieldName = equippedShield.get(0).getLabel();
        }
        return equippedShieldName;
    }

    public String getEquippedArmorName() {
        if(equippedArmor.size()==0){
            equippedArmorName = "None";
        }
        else {
            equippedArmorName = equippedArmor.get(0).getLabel();
        }
        return equippedArmorName;
    }

    public String getEquippedWeaponName() {
        if(equippedWeapon.size()==0){
            equippedWeaponName = "None";
        }
        else {
            equippedWeaponName = equippedWeapon.get(0).getLabel();
        }
        return equippedWeaponName;
    }

    public String getLastLocationName(){
        if (lastLocation ==null){
            return "None";
        }
        else {
            return lastLocation.getLabel();
        }
    }

    @Override
    public String toString() {



        if (equippedWeapon.size()==0){

        }

        return "************************************************************\n" +
                "Looking at Player\n" +
                "************************************************************\n" +
                "Current location :: ["+ currentLocation.getLabel()+"]\n" +
                "************************************************************\n" +
                "Last location :: ["+ getLastLocationName()+"]\n" +
                "************************************************************\n" +
                "Equipped Weapon:: ["+getEquippedWeaponName()+"]\n" +
                "************************************************************\n" +
                "Equipped Shield :: ["+getEquippedShieldName()+"]\n" +
                "************************************************************\n" +
                "Equipped Armor :: ["+getEquippedArmorName()+"]\n" +
                "************************************************************\n";
    }
}
