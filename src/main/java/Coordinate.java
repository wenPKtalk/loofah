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
        switch (this.direction) {
            case NORTH:
                toWest();
                break;
            case WEST:
                toSouth();
                break;
            case SOUTH:
                toEast();
                break;
            case EAST:
                toNorth();
                break;
        }
    }

    public void turnRight() {
        switch (this.direction) {
            case NORTH:
                toEast();
                break;
            case WEST:
                toNorth();
                break;
            case SOUTH:
                toWest();
                break;
            case EAST:
                toSouth();
                break;
        }
    }

    public void move(Mesh mesh) {
        switch (this.direction) {
            case NORTH:
                this.vertical++;
                break;
            case SOUTH:
                this.vertical--;
                break;
            case WEST:
                this.horizontal--;
                break;
            case EAST:
                this.horizontal++;
                break;
        }
        if (isOutBound(mesh)) {
            throw new OutBoundException("Out bound");
        }
    }

    private boolean isOutBound(Mesh mesh) {
        return this.vertical < 0
                || this.horizontal < 0
                || this.vertical > mesh.getHeight()
                || this.horizontal > mesh.getWidth();
    }

    private void toNorth() {
        this.direction = Direction.NORTH;
    }

    private void toSouth() {
        this.direction = Direction.SOUTH;
    }

    private void toEast() {
        this.direction = Direction.EAST;
    }

    private void toWest() {
        this.direction = Direction.WEST;
    }
}
