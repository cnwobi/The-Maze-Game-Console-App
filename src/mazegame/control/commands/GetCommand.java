package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.control.commands.Command;
import mazegame.entity.Collectible;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class GetCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player player) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse ("If you want to get item you need to tell me what.");
        }
        String itemLabel = (String) userInput.getArguments().get(0);
        Item desiredItem = player.getCurrentLocation().getItem(itemLabel);
       if(desiredItem==null){
           return new CommandResponse("This item does not exist in this location....type in look to view available items");
       }
       if (player.getPlayerInventory().getItem(itemLabel)== desiredItem){
           return new CommandResponse("Cannot get this item...The player already has " + desiredItem.getLabel() + " in inventory");
       }
       if(desiredItem.getWeight() > player.getWeightLimit()){
           return new CommandResponse("Cannot carry item...Weight limit reached");
       }
       /*if (desiredItem instanceof Collectible){
           if(player.getLifePoints()<20){
               player.setLifePoints(player.getLifePoints()+((Collectible) desiredItem).getRestoreLifepoint());
               int restorationPoint= ((Collectible) desiredItem).getRestoreLifepoint();
               player.getCurrentLocation().removeItem(itemLabel);
               return new CommandResponse("Life points restored by +"+restorationPoint);
           }
           return new CommandResponse("Life points full already!");
       }*/
       player.setWeightLimit(((int)desiredItem.getWeight()));
       player.getPlayerInventory().addItem(desiredItem);
       player.getCurrentLocation().removeItem(itemLabel);
       return new CommandResponse("You successfully added " + itemLabel + " and your remaining weight  capacity is :" + player.getWeightLimit()+" lb");
    }
}
