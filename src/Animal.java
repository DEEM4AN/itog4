import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    private String name;
    protected List<String> commands;

    public Animal(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void learnCommand(String command) {
        if (!commands.contains(command)) {
            commands.add(command);
        }
    }

    public abstract String getType();
}