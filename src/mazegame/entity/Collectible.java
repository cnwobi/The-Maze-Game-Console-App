package mazegame.entity;

public class Collectible extends Item {
    private int restoreLifepoint;
    public Collectible(String label, int restoreLifePoint) {
        super(label);
        this.restoreLifepoint= restoreLifePoint;
    }

    public int getRestoreLifepoint() {
        return restoreLifepoint;
    }
}
