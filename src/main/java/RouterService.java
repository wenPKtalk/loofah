import lombok.Builder;

import java.util.List;

public class RouterService {
    private final Mesh mesh;

    @Builder
    public RouterService(final int width, final int height) {
        this.mesh = Mesh.builder()
                .width(width)
                .height(height)
                .build();
    }

    public Coordinate findCoordinate(final Coordinate coordinate,
                                     final List<Order> orders) {
        orders.forEach(order -> this.moveStrategy(coordinate, order));
        return coordinate;
    }

    private void moveStrategy(final Coordinate coordinate,
                              final Order order) {
        if (Order.LEFT.equals(order)) {
            coordinate.turnLeft();
        }

        if (Order.RIGHT.equals(order)) {
            coordinate.turnRight();
        }

        if (Order.MOVE.equals(order)) {
            coordinate.move();
        }
    }
}
