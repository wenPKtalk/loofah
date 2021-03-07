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
            return;
        }
        if (this.direction.equals(Direction.WEST)) {
            this.direction = Direction.SOUTH;
            return;
        }
        if (this.direction.equals(Direction.SOUTH)) {
            this.direction = Direction.EAST;
            return;
        }
        if (this.direction.equals(Direction.EAST)) {
            this.direction = Direction.NORTH;
        }
    }

    public void turnRight() {
        if (this.direction.equals(Direction.NORTH)) {
            this.direction = Direction.EAST;
            return;
        }
        if (this.direction.equals(Direction.EAST)) {
            this.direction = Direction.SOUTH;
            return;
        }
        if (this.direction.equals(Direction.SOUTH)) {
            this.direction = Direction.WEST;
            return;
        }
        if (this.direction.equals(Direction.WEST)) {
            this.direction = Direction.NORTH;
        }
    }

    public void move() {
        if (this.direction.equals(Direction.NORTH)) {
            this.vertical++;
            return;
        }

        if (this.direction.equals(Direction.SOUTH)) {
            this.vertical--;
            return;
        }

        if (this.direction.equals(Direction.WEST)) {
            this.horizontal--;
            return;
        }

        if (this.direction.equals(Direction.EAST)) {
            this.horizontal++;
        }
    }
}
