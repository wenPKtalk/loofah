public class RightRotateCommand implements Command{

    @Override
    public void execute(Coordinate coordinate) {
        coordinate.turnRight();
    }
}
