import java.util.ArrayList;
import java.util.List;

public class CommandList implements Command{
    private  static CommandList commands;
    private List<Command> commandList;

    public static CommandList getCommands() {
        if(commands == null) {
            commands = new CommandList();
        }
        return commands;
    }

    public void addCommand(Command toAdd) {
        if(commandList == null) {
            commandList = new ArrayList<>();
        }
        commandList.add(toAdd);
    }

    @Override
    public void execute() {
        for(int i=0;i<commandList.size();i++) {
            Command command = commandList.get(i);
            if(command != null)
                command.execute();
        }
    }

    public static void flush() {
        CommandList.commands = null;
    }
}
