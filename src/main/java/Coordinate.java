import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinate {
    private static final int ZERO = 0;
    private int horizontal;
    private int vertical;
    private Direction direction;
    private Mesh mesh;

    public void turnLeft() {
        this.direction = this.direction.left();
    }

    public void turnRight() {
        this.direction = this.direction.right();
    }

    public void move() {
        this.horizontal += this.direction.getStepSizeOnXAxis();
        this.vertical += this.direction.getStepSizeOnYAxis();
        if (isOutBound()) {
            throw new OutBoundException("Out bound");
        }
    }

    private boolean isOutBound() {
        return this.vertical < 0
                || this.horizontal < 0
                || this.vertical > this.mesh.getHeight()
                || this.horizontal > this.mesh.getWidth();
    }
}
