package mazegame.utility;

import mazegame.entity.Item;

import java.util.HashMap;

public class ArmorTable {
    private static ArmorTable instance;
    private HashMap<String,Item> lookup;
    private ArmorTable(HashMap<String,Item> hashMap){
        lookup = hashMap;
    }
    public static ArmorTable getInstance(){
        if(instance ==null){
            instance = new ArmorTable(new HashMap<>());
        }
        return instance;
    }
    public void setArmor(String lable, Item armor){
        lookup.put(lable, armor);
    }
    public Object getArmor(String label){
        if(lookup.keySet().contains(label)){
            return lookup.get(label);
        }
        return null;
    }
}
