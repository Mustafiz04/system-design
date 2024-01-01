package behavioral.command;

public class TvOnCommand implements Command {
    TV tv;
    public TvOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOn();
    }
}
