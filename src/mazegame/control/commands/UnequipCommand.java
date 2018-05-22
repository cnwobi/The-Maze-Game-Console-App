package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Player;

public class UnequipCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {

            if (player.getEquippedWeapon().size()==0) {
                return new CommandResponse ("You have no equipped weapon to unequip");
            }
            player.getEquippedWeapon().remove(0);
            return new CommandResponse ("You successfully unequipped your weapon");

    }
}
