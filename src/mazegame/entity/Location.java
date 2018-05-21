package mazegame.entity;

import java.util.HashMap;

public class Location {
    private HashMap exits;
    private String description;
    private String label;
    private HashMap<String, NonPlayerCharacter> nonPlayerCharacters;
    private HashMap weapons;
    private HashMap inventory;

    public Location() {
    }

    public Location(String description, String label) {
        this.setDescription(description);
        this.setLabel(label);
        exits = new HashMap();
        nonPlayerCharacters = new HashMap();
        weapons = new HashMap();
        inventory = new HashMap();
    }

    public boolean addNonPlayerCharacters(String characterName, NonPlayerCharacter nonPlayerCharacter) {
        if (nonPlayerCharacters.containsKey(characterName))
            return false;
        nonPlayerCharacters.put(characterName, nonPlayerCharacter);
        return true;
    }

    public boolean addWeapons(String label, Item weapon) {
        if (weapons.containsKey(label))
            return false;
        weapons.put(label, weapon);
        return true;
    }

    public boolean addExit(String exitLabel, Exit theExit) {
        if (exits.containsKey(exitLabel))
            return false;
        exits.put(exitLabel, theExit);
        return true;
    }

    public boolean addItems(String inventoryLabel, Item item) {
        if (inventory.containsKey(inventoryLabel))
            return false;
        inventory.put(inventoryLabel, item);
        return true;
    }

    public Exit getExit(String exitLabel) {
        return (Exit) exits.get(exitLabel);
    }

    public NonPlayerCharacter getNonPlayerCharacters(String characterName) {
        return (NonPlayerCharacter) nonPlayerCharacters.get(characterName);
    }

    public Item getItem(String label) {
        return (Item) inventory.get(label);
    }

    public void removeItem(String label) {
        if (inventory.containsKey(label)) {
            inventory.remove(label);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String availableExits() {
        StringBuilder returnMsg = new StringBuilder();
        for (Object label : this.exits.keySet()) {
            returnMsg.append("[" + label.toString() + "] ");
        }
        return returnMsg.toString();
    }

    public String availableCharacters() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object characterName : this.nonPlayerCharacters.keySet()) {
            stringBuilder.append("[" + characterName.toString() + "] ");
        }
        return stringBuilder.toString();
    }

    public HashMap<String, NonPlayerCharacter> getNonPlayerCharacters() {
        return nonPlayerCharacters;
    }

    public String availableItems() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object item : this.inventory.keySet()) {
            stringBuilder.append("[" + item.toString() + "] ");
        }
        return stringBuilder.toString();
    }

    public boolean containsExit(String exitLabel) {
        return exits.containsKey(exitLabel);
    }

    public boolean containsCharacter(String characterName) {
        return nonPlayerCharacters.containsKey(characterName);
    }

    public boolean containsWeapon(String label) {
        return inventory.containsKey(label);
    }

    public String toString() {
        return "************************************************************\n" + this.label + "\n************************************************************\n"
                + "Exits found :: " + availableExits() + "\n************************************************************\n"
                + "Characters found :: " + availableCharacters() + "\n************************************************************\n"
                + "Items found :: " + availableItems() + "\n************************************************************\n"
                + this.description + "\n************************************************************\n";
    }
}
