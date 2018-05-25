package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Player;

public class ListCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("\n******************************************\n " +
                    "--Player inventory--" +
                    "\n******************************************\n "
                    + player.getPlayerInventory().printItemList() +
                    "\n******************************************\n" +
                    "Available Money :: " + player.getPlayerInventory().getGold().toString() +
                    "\n******************************************\n " +
                    "Available Weight Carrying Capacity :: " + player.getWeightLimit() + " lb" +
                    " \n******************************************");
        }
        if (userInput.getArguments() .contains("location"))
        {
            return new CommandResponse(player.getCurrentLocation().toString());
        }
        if(userInput.getArguments() .contains("player"))
        {

        }

        return new CommandResponse( "Didn't find that to list");
    }
}
