package mazegame.entity;

public class Weapon extends Item {
	
	public Dice m_Dice;
	private int diceFace;
	private int numberOfRolls;


    public Weapon(String label, int price, double weight, String description, int diceFace, int numberOfRolls) {
         super (label, price, weight, description);
         this.diceFace = diceFace;
         this.numberOfRolls = numberOfRolls;
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }


    @Override
    public String getDescription() {
        return super.getDescription();
    }



    @Override
    public double getWeight() {
        return super.getWeight();
    }

    public int getDiceFace() {
        return diceFace;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }
    public String toString() {
        return "Item :: Weapon\n**************************************************************************\n" +
                "Weapon Name :: " + super.getLabel() + "\n**************************************************************************\n"
                + "Value :: " +super.getPrice() + " gp\n**************************************************************************\n"+
                "Weight :: " + super.getWeight() +" lb \n**************************************************************************\n"+
                "Description :: " + super.getDescription() + "\n**************************************************************************\n"+
                "Damage :: "+numberOfRolls+"d"+diceFace+"\n**************************************************************************\n"
                ;
    }
}
