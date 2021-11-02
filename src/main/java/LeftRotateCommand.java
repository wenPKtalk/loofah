public class LeftRotateCommand implements Command{

    @Override
    public void execute(Coordinate coordinate) {
        coordinate.turnLeft();
    }
}
