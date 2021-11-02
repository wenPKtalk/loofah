import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterServiceTest {
    @Test
    public void should_1_3_N() {
        RouterService routerService = RouterService.builder()
                .build();
        Mesh mesh = Mesh.builder().height(5).width(5).build();
        List<CommandStrategy> commandStrategies = ImmutableList.of(CommandStrategy.LEFT,
                CommandStrategy.MOVE,
                CommandStrategy.LEFT,
                CommandStrategy.MOVE,
                CommandStrategy.LEFT,
                CommandStrategy.MOVE,
                CommandStrategy.LEFT,
                CommandStrategy.MOVE,
                CommandStrategy.MOVE);
        Coordinate startCoordinate = Coordinate.builder()
                .horizontal(1)
                .vertical(2)
                .mesh(mesh)
                .direction(Direction.NORTH)
                .build();
        Coordinate coordinate = routerService.findCoordinate(startCoordinate, commandStrategies);
        Coordinate result = Coordinate.builder()
                .horizontal(1)
                .vertical(3)
                .direction(Direction.NORTH)
                .mesh(mesh)
                .build();
        assertEquals(result, coordinate);
    }

    @Test
    public void should_5_1_E() {
        RouterService routerService = RouterService.builder()
                .build();
        Mesh mesh = Mesh.builder().height(5).width(5).build();
        List<CommandStrategy> commandStrategies = ImmutableList.of(CommandStrategy.MOVE,
                CommandStrategy.MOVE,
                CommandStrategy.RIGHT,
                CommandStrategy.MOVE,
                CommandStrategy.MOVE,
                CommandStrategy.RIGHT,
                CommandStrategy.MOVE,
                CommandStrategy.RIGHT,
                CommandStrategy.RIGHT,
                CommandStrategy.MOVE);
        Coordinate startCoordinate = Coordinate.builder()
                .horizontal(3)
                .vertical(3)
                .direction(Direction.EAST)
                .mesh(mesh)
                .build();
        Coordinate coordinate = routerService.findCoordinate(startCoordinate, commandStrategies);
        Coordinate result = Coordinate.builder()
                .horizontal(5)
                .vertical(1)
                .direction(Direction.EAST)
                .mesh(mesh)
                .build();
        assertEquals(result, coordinate);
    }

    @Test
    public void should_outBoundsException() {
        RouterService routerService = RouterService.builder()
                .build();
        Mesh mesh = Mesh.builder().height(5).width(5).build();
        List<CommandStrategy> commandStrategies = ImmutableList.of(CommandStrategy.MOVE,
                CommandStrategy.MOVE,
                CommandStrategy.RIGHT,
                CommandStrategy.MOVE,
                CommandStrategy.MOVE,
                CommandStrategy.RIGHT,
                CommandStrategy.MOVE,
                CommandStrategy.RIGHT,
                CommandStrategy.RIGHT,
                CommandStrategy.MOVE,
                CommandStrategy.MOVE,
                CommandStrategy.MOVE);
        Coordinate startCoordinate = Coordinate.builder()
                .horizontal(3)
                .vertical(3)
                .mesh(mesh)
                .direction(Direction.EAST)
                .build();
        assertThrows(OutBoundException.class, () -> routerService.findCoordinate(startCoordinate, commandStrategies));
    }
}
