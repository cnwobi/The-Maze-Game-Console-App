package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class BuyCommand implements Command {
    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        /*
        * If the buy command is issued it must have an argument
        * Like all the commands, the argument is used to fetch an item from the player inventory with a label that corresponds to
        * the argument
        *
        * If object is found and player can afford the item ie item.getPrice< player.coins, deduct price by calling the subtract method in money class
         * finally add the bought item to inventory*/

        if (input.getArguments().size() == 0) {
            return new CommandResponse ("If you want to buy an item you need to tell me what");
        }

        String itemLabel = (String) input.getArguments().get(0);
        Item desiredItem = thePlayer.getCurrentLocation().getItem(itemLabel);

        if(desiredItem==null){
            return new CommandResponse("This item does not exist in this location....type in look to view available items");
        }


        if (thePlayer.getPlayerInventory().getGold().getTotal() < desiredItem.getPrice()){
            return new CommandResponse("Cannot purchase item, you are low on gold points");
        }


        if(desiredItem.getWeight() > thePlayer.getWeightLimit()){
            return new CommandResponse("Cannot carry item...Weight limit reached");
        }

        double accountBalanceBeforeBuy= thePlayer.getPlayerInventory().getGold().getTotal();

        thePlayer.getPlayerInventory().getGold().subtract(desiredItem.getPrice());

        thePlayer.getPlayerInventory().addItem(desiredItem);

        thePlayer.setWeightLimit(((int)desiredItem.getWeight()));

        String stars ="****************************************************\n";
        return new CommandResponse (stars+"--Transaction Complete--\n"+stars +
                "You successfully bought ["+itemLabel+"] for "+ (desiredItem.getPrice()) +
                " gp\n"+stars+"Your account balance before the sale was "+accountBalanceBeforeBuy+" gp\n"+stars+"Your account balance after the sale is " +thePlayer.getPlayerInventory().getGold().getTotal()+" gp\n"+stars);
    }
}



