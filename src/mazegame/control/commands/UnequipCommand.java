package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Player;

public class UnequipCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {

        if (userInput.getArguments().contains("weapon")) {
            if (player.getEquippedWeapon().size()==0) {
                return new CommandResponse ("You have no equipped weapon to unequip");
            }
            else {
                player.getEquippedWeapon().remove(0);
                return new CommandResponse ("You successfully unequipped your weapon");
            }
        } else if (userInput.getArguments().size()==0){
            return new CommandResponse("If you want to unequip an item you need to tell me which");}
            else if(userInput.getArguments().contains("armor")){
               if (player.getEquippedArmor().size()==0){
                   return new CommandResponse("You have no equipped armor to unequip");
               }
               else {
                   player.getEquippedArmor().remove(0);
                   return new CommandResponse("You successfully unequipped your armor");
               }
            }
            else if (userInput.getArguments().contains("shield")){
            if(player.getEquippedShield().size()==0){
                return new CommandResponse("You have no equipped shield to unequip");
            }
            player.getEquippedShield().remove(0);
            return new CommandResponse("You successfully unequipped your shield");
        }

        return new CommandResponse("Could not find that to unequip");
    }
}
