package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Exit;
import mazegame.entity.Item;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class LookCommand implements Command {

    private CommandResponse response;

    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        response = new CommandResponse("Can't find that to look at here!");
        if (userInput.getArguments().size() == 0){
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        if(userInput.getArguments().contains("location")) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        if(userInput.getArguments().contains("player")){
            response.setMessage(thePlayer.toString());
            return response;
        }
        for (Object argument: userInput.getArguments()) {
            /*This for loop checks the location if it contains
            * an exit, character*/
            if (thePlayer.getCurrentLocation().containsExit(argument.toString())) {
                Exit theExit = thePlayer.getCurrentLocation().getExit((String)argument);
                return new CommandResponse(theExit.getDescription());
            }
            else if (thePlayer.getCurrentLocation().containsCharacter(argument.toString())){
                NonPlayerCharacter nonPlayerCharacter = thePlayer.getCurrentLocation().getNonPlayerCharacters((String) argument);

                return new CommandResponse(nonPlayerCharacter.toString());
            }
            else if (thePlayer.getCurrentLocation().containsItem(argument.toString())){
                Item item = thePlayer.getCurrentLocation().getItem((String) argument);
                return new CommandResponse(item.toString());
            }
        }
        return response;
    }
}
