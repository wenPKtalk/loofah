import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinate {
    private static final int ZERO = 0;
    private int horizontal;
    private int vertical;
    private Direction direction;

    public void turnLeft() {
        if (this.direction.equals(Direction.NORTH)) {
            this.direction = Direction.WEST;
        }
        if (this.direction.equals(Direction.WEST)) {
            this.direction = Direction.SOUTH;
        }
        if (this.direction.equals(Direction.SOUTH)) {
            this.direction = Direction.EAST;
        }
        if (this.direction.equals(Direction.EAST)) {
            this.direction = Direction.NORTH;
        }
    }

    public void turnRight() {
        if (this.direction.equals(Direction.NORTH)) {
            this.direction = Direction.EAST;
        }
        if (this.direction.equals(Direction.EAST)) {
            this.direction = Direction.SOUTH;
        }
        if (this.direction.equals(Direction.SOUTH)) {
            this.direction = Direction.WEST;
        }
        if (this.direction.equals(Direction.WEST)) {
            this.direction = Direction.NORTH;
        }
    }

    public void move() {
        if (this.direction.equals(Direction.NORTH)) {
            this.vertical++;
        }

        if (this.direction.equals(Direction.SOUTH)) {
            this.vertical--;
        }

        if (this.direction.equals(Direction.WEST)) {
            this.horizontal--;
        }

        if (this.direction.equals(Direction.EAST)) {
            this.horizontal++;
        }
    }
}
