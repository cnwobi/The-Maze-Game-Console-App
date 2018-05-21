package mazegame.control;

import java.util.ArrayList;

public class ParsedInput {
private String command;
private ArrayList arguments;

    public ParsedInput() {
        this.arguments= new ArrayList();
        this.command="";

    }

    public ParsedInput(String command, ArrayList arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList arguments) {
        this.arguments = arguments;
    }
}
