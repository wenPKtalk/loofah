import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouterServiceTest {
    @Test
    public void should_1_3_N() {
        RouterService routerService = RouterService.builder()
                .height(5)
                .width(5)
                .build();
        List<Order> orders = ImmutableList.of(Order.LEFT,
                Order.MOVE,
                Order.LEFT,
                Order.MOVE,
                Order.LEFT,
                Order.MOVE,
                Order.LEFT,
                Order.MOVE,
                Order.MOVE);
        Coordinate startCoordinate = Coordinate.builder()
                .horizontal(1)
                .vertical(2)
                .direction(Direction.NORTH)
                .build();
        Coordinate coordinate = routerService.findCoordinate(startCoordinate, orders);
        Coordinate result = Coordinate.builder()
                .horizontal(1)
                .vertical(3)
                .direction(Direction.NORTH)
                .build();
        assertEquals(result, coordinate);
    }


    @Test
    public void should_5_1_E() {
        RouterService routerService = RouterService.builder()
                .height(5)
                .width(5)
                .build();
        List<Order> orders = ImmutableList.of(Order.MOVE,
                Order.MOVE,
                Order.RIGHT,
                Order.MOVE,
                Order.MOVE,
                Order.RIGHT,
                Order.MOVE,
                Order.RIGHT,
                Order.RIGHT,
                Order.MOVE);
        Coordinate startCoordinate = Coordinate.builder()
                .horizontal(3)
                .vertical(3)
                .direction(Direction.EAST)
                .build();
        Coordinate coordinate = routerService.findCoordinate(startCoordinate, orders);
        Coordinate result = Coordinate.builder()
                .horizontal(5)
                .vertical(1)
                .direction(Direction.EAST)
                .build();
        assertEquals(result, coordinate);
    }

    @Test
    public void should_outBoundsException() {
        RouterService routerService = RouterService.builder()
                .height(5)
                .width(5)
                .build();
        List<Order> orders = ImmutableList.of(Order.MOVE,
                Order.MOVE,
                Order.RIGHT,
                Order.MOVE,
                Order.MOVE,
                Order.RIGHT,
                Order.MOVE,
                Order.RIGHT,
                Order.RIGHT,
                Order.MOVE,
                Order.MOVE,
                Order.MOVE);
        Coordinate startCoordinate = Coordinate.builder()
                .horizontal(3)
                .vertical(3)
                .direction(Direction.EAST)
                .build();
        assertThrows(OutBoundException.class, ()-> {
            routerService.findCoordinate(startCoordinate, orders);
        });
    }
}
