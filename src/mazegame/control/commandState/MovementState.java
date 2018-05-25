package mazegame.control.commandState;
import mazegame.control.commands.*;
import mazegame.entity.Blacksmith;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class MovementState extends CommandState {
    public MovementState()
    {
        this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("quit", new QuitCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("unlock", new UnlockCommand());
       // this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("get", new GetCommand());
        this.getAvailableCommands().put("drop", new DropCommand());
        this.getAvailableCommands().put("list",new ListCommand());
        this.getAvailableCommands().put("equip",new EquipCommand());
        this.getAvailableCommands().put("unequip",new UnequipCommand());
        this.getAvailableCommands().put("use",new UseCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Blacksmith)
            return new CommerceState();
     for(NonPlayerCharacter npc: thePlayer.getCurrentLocation().getNonPlayerCharacters().values()){
         // iterate through the characters in a location if a hostile character is present initiate the attack state
         if(npc.getHostile() == true){
            /* System.out.println("*****Hostile Character in Location****");*/
             return  new AttackState();
         }
     }
        return this;
    }
}
