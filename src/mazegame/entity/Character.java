package mazegame.entity;

public class Character {
	private int agility;
    private int lifePoints;
    private String name;
    private int strength;
    private static  final int MAX_LIFEPOINTS = 20;



    
    public Character()
    {
    }

    public Character(String name)
    {
        this.setName(name);
    }

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String restorLifePoints(int lifePoints){
    	if (lifePoints + this.lifePoints > MAX_LIFEPOINTS){
    		this.lifePoints =MAX_LIFEPOINTS;
    		return "*****Life points restored to MAXIMUM*****";
		}
		else{
    		this.lifePoints+=lifePoints;
    		return "*****Life points restored by "+ lifePoints +" LP\nLife points is now "+this.lifePoints+" LP";
		}
	}
}
