package mazegame.utility;

import mazegame.entity.Item;
import mazegame.entity.Weapon;

import java.util.HashMap;

public class WeaponTable {
    private static WeaponTable instance;
    private HashMap<String,Item> lookup;

    private WeaponTable(HashMap<String,Item> theTable){
        lookup = theTable;

    }
    public static WeaponTable getInstance () {
        if (instance == null) {
            instance = new WeaponTable (new HashMap<String, Item>());
        }
        return instance;
    }
    public void setWeapon(String label, Item weapon) {
        lookup.put(label, weapon);
    }
    public Object getWeapon(String label){



        if (lookup.keySet().contains(label)){
            return lookup.get(label);
        }
        return null;
    }
}
