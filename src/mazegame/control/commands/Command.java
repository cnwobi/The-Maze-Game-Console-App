package mazegame.control.commands;

import mazegame.control.CommandResponse;
import mazegame.control.ParsedInput;
import mazegame.entity.Player;

public interface Command {
     CommandResponse execute(ParsedInput userInput, Player player);
}
