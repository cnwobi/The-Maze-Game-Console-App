package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Collectible;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class UseCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse ("If you want to use you need to tell me which.");
        }
        String itemLabel = (String) userInput.getArguments().get(0);

        Item item =  player.getPlayerInventory().getItem(itemLabel);
        if (item == null){
            return new CommandResponse("The item [" + itemLabel+"] was not found in the player's inventory");
        }

        if(item instanceof Collectible){
            player.getPlayerInventory().removeItem(itemLabel);
            return new CommandResponse(player.restorLifePoints(((Collectible) item).getRestoreLifepoint()));
        }
        return new CommandResponse("You cannot use this item ["+itemLabel+"] to restore life points it is not a collectible");


    }
}
