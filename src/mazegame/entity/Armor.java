package mazegame.entity;

public class Armor extends Item {
	private int bonus;	

	public Armor (String label, int value, int bonus, double weight) {
		super (label, value, weight, "");
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public String toString() {
		return "Item :: Armor\n**************************************************************************\n" +
				"Armor Name :: " + super.getLabel() + "\n**************************************************************************\n"
				+ "Price :: " +super.getPrice() + " gp\n**************************************************************************\n"+
				"Weight :: " + super.getWeight() +" lb \n**************************************************************************\n"+
				"Description :: " + super.getDescription() + "\n**************************************************************************\n"+
				"Bonus :: +"+bonus+"\n**************************************************************************\n"
				;
	}
}
