package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;

import mazegame.entity.*;

public class EquipCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {
        /*
        * The equip command must take an argument
        * The argument is used to fetch an object who's key (label) matches the argument
        * Furthermore the Equip command returns a certain command response based on the state of the
        * retrieved object.
        * The retrieved object can be a weapon,shield or armor
        * */


        if (userInput.getArguments().size() == 0) {
            return new CommandResponse ("If you want to equip a weapon you need to tell me which.");
        }
        String itemLabel = (String) userInput.getArguments().get(0);

        Item item =  player.getPlayerInventory().getItem(itemLabel);
        if (item == null){
            return new CommandResponse("The item [" + itemLabel+"] was not found in the player's inventory");
        }
        if (item instanceof Weapon){

            return new CommandResponse(player.equipWeapon((Weapon) item));
        }
        if (item instanceof Shield){

            return new CommandResponse(player.equipShield((Shield)item));
        }

         return  new CommandResponse(player.equipArmor((Armor)item));

    }
}
