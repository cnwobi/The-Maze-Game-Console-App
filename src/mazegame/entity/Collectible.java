package mazegame.entity;

import mazegame.utility.DiceRoller;

public class Collectible extends Item {
    private DiceRoller diceRoller = DiceRoller.getInstance();
    private int restoreLifepoint;
    public Collectible(String label, int restoreLifePoint) {
        super(label);
        this.restoreLifepoint= diceRoller.generateAbilityScore(6,2);
    }

    public int getRestoreLifepoint() {
        return restoreLifepoint;
    }
}
