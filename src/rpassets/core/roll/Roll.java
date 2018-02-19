package rpassets.core.roll;

public class Roll {
    private final String command;

    public Roll(String command) {
        this.command = command.toLowerCase();
    }

    public int roll() {
        return new RollParser(command).roll();
    }

    @Override
    public String toString() {
        return this.command;
    }
}
