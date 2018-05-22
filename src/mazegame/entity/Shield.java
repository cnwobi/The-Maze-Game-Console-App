package mazegame.entity;

public class Shield extends Item{
    private int bonus;
    public Shield(String label, int price, double weight,int bonus) {
        super(label, price, weight, "");
        this.bonus=bonus;
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public String toString() {
        return "Item ::Shield\n**************************************************************************\n" +
                "Shield Name :: " + super.getLabel() + "\n**************************************************************************\n"
                + "Price :: " +super.getPrice() + " gp\n**************************************************************************\n"+
                "Weight :: " + super.getWeight() +" lb \n**************************************************************************\n"+
                "Description :: " + super.getDescription() + "\n**************************************************************************\n"+
                "Bonus :: +"+bonus+"\n**************************************************************************\n"
                ;
    }
}
