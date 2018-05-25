package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.control.commands.Command;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class DropCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse ("If you want to drop item you need to tell me what.");
        }
        String itemLabel = (String) userInput.getArguments().get(0);
        Item desiredItem = player.getPlayerInventory().getItem(itemLabel);
        if(desiredItem == null){
            return new CommandResponse("The specified item " +itemLabel+ " does not exist in player inventory");
        }
        Item removedItem = player.getPlayerInventory().getItemList().get(itemLabel);
        player.getPlayerInventory().removeItem(itemLabel);
        player.setWeightLimit(player.getWeightLimit()+(int)removedItem.getWeight());
        player.getCurrentLocation().addItems(itemLabel,removedItem);
        return new CommandResponse("Item has been removed from inventory");
    }
}
