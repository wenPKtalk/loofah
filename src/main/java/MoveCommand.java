public class MoveCommand implements Command{
    @Override
    public void execute(Coordinate coordinate) {
        coordinate.move();
    }
}
