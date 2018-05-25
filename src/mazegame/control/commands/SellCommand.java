package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.control.commands.Command;
import mazegame.entity.Item;
import mazegame.entity.Player;

public class SellCommand implements Command {
    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        if (input.getArguments().size() == 0) {
            return new CommandResponse ("If you want to sell an item you need to tell me what");
        }
        String itemLabel = (String)input.getArguments().get(0);
        Item desiredWeapon =  thePlayer.getPlayerInventory().getItem(itemLabel);
        if(desiredWeapon == null){
            return new CommandResponse("The item you are attempting to sell does not exist in the player's inventory");
        }
         double accountBalanceBeforeSale= thePlayer.getPlayerInventory().getGold().getTotal();
        thePlayer.getPlayerInventory().addMoney(desiredWeapon.getPrice()*0.8);
        Item removedItem = thePlayer.getPlayerInventory().getItem(itemLabel);
        thePlayer.getPlayerInventory().removeItem(itemLabel);
        thePlayer.setWeightLimit(thePlayer.getWeightLimit()+(int)removedItem.getWeight());
        String stars ="****************************************************\n";
        return new CommandResponse (stars+"--Transaction Complete--\n"+stars +
                "You successfully sold ["+itemLabel+"] for "+ (desiredWeapon.getPrice()*.80) +
                " gp\n"+stars+"Your account balance before the sale was "+accountBalanceBeforeSale+" gp\n"+stars+"Your account balance after the sale is " +thePlayer.getPlayerInventory().getGold().getTotal()+" gp\n"+stars);
    }
}


