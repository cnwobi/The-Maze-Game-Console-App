package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.control.commands.Command;
import mazegame.entity.Player;

public class UnlockCommand implements Command {
    public CommandResponse execute (ParsedInput input, Player thePlayer) {
        return new CommandResponse ("You entered the unlock command");
    }
}
