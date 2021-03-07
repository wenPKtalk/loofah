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
        orders.forEach(order -> order.moveStrategy(coordinate));
        return coordinate;
    }
}
