package mazegame.entity;

public class Exit {
	private String description;
	private Location destination;
	private boolean  locked;
	
	public Exit (String description, Location destination)
	{
		this.setDescription(description);
		this.setDestination(destination);
		locked=false;
	}

	public Exit(String description, Location destination, boolean locked) {
		this.description = description;
		this.destination = destination;
		this.locked = locked;
	}

	public boolean isLocked() {

		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
