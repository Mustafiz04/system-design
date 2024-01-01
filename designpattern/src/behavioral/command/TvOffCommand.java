package behavioral.command;

public class TvOffCommand implements Command {
    TV tv;

    public TvOffCommand (TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOff();
    }
}
