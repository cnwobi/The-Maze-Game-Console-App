package mazegame.control.commandState;

import mazegame.control.commands.*;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class AttackState extends CommerceState {
    public AttackState(){

        this.getAvailableCommands().put("flee", new MoveCommand());

        this.getAvailableCommands().put("attack", new AttackCommand());

    }
    public CommandState update(Player thePlayer)
    {
        for(NonPlayerCharacter npc: thePlayer.getCurrentLocation().getNonPlayerCharacters().values()){
            if(npc.getHostile() == true){
                return  this;
            }
        }

        return new MovementState();

    }
}
