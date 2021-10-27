import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Order {
    LEFT("L"), RIGHT("R"), MOVE("M");
    @Getter
    private final String order;

    public void moveStrategy(final Coordinate coordinate, Mesh mesh) {
        switch (this) {
            case LEFT:
                coordinate.turnLeft();
                break;
            case RIGHT:
                coordinate.turnRight();
                break;
            default:
                coordinate.move(mesh);
                break;
        }
    }
}
