package mazegame.entity;

public abstract class Item {
	
	private String label;
	private int price;
	private double weight;
	private String description;

	public Item(String label) {
		this.label = label;
	}

	public Item (String label, int price, double weight, String description)
	{
		this.label = label;
		this.price = price;//(int) weight*100
		this.weight = weight;
		this.description = description;
	}

	public String getLabel() {

		return label;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public String getDescription()
	{
		return description;
	}

	@Override
	public String toString() {
		return "Item\n**************************************************************************\n" +
				"Item Name :: " + label + "\n**************************************************************************\n"
				+ "Value :: " + price + " gp\n**************************************************************************\n"+
				"Weight :: " + weight +" lb \n**************************************************************************\n"+
				"Description :: " + description + "\n**************************************************************************\n"
				;
	}

}
