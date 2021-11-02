import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CommandStrategy {
    LEFT("L"), RIGHT("R"), MOVE("M");
    @Getter
    private final String order;
    private static final ImmutableMap<CommandStrategy, Command> STRATEGY_EXECUTOR = ImmutableMap.of(LEFT, new LeftRotateCommand(),
            RIGHT, new RightRotateCommand(),
            MOVE, new MoveCommand());

    public void moveStrategy(final Coordinate coordinate) {
        Command command = STRATEGY_EXECUTOR.get(this);
        command.execute(coordinate);
    }
}
