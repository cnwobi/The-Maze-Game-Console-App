package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.control.commands.Command;
import mazegame.entity.Player;

public class InvCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse ("If you want to get me which inventory you need to tell me what.\n****Enter [inv location] ... to view location items\n****Enter [inv player]... to view items in player inventory");
        }
        if (userInput.getArguments() .contains("location"))
        {
            return new CommandResponse("Current Location("+player.getCurrentLocation().getLabel()+") Inventory ===> " +player.getCurrentLocation().availableItems());
        }
        if(userInput.getArguments() .contains("player"))
        {
            return new CommandResponse( "--Player inventory--\n******************************************\n "+ player.getPlayerInventory().printItemList()+"\n******************************************\nAvailable Money :: "+player.getPlayerInventory().getGold().toString()+"\n******************************************\n Available Weight Carrying Capacity :: "+player.getWeightLimit()+" lb");
        }

        return new CommandResponse( "Didn't find that to list");
    }
}
