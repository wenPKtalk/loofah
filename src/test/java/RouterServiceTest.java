import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterServiceTest {
    @Test
    public void should_13N_when_MLMLMLMM() {
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
        Coordinate coordinateActual = routerService.findCoordinate(startCoordinate, commandStrategies);
        Coordinate except = Coordinate.builder()
                .horizontal(1)
                .vertical(3)
                .direction(Direction.NORTH)
                .mesh(mesh)
                .build();
        assertEquals(except, coordinateActual);
    }

    @Test
    public void should_51E_when_MRMMRMRRM() {
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
        Coordinate coordinateActual = routerService.findCoordinate(startCoordinate, commandStrategies);
        Coordinate except = Coordinate.builder()
                .horizontal(5)
                .vertical(1)
                .direction(Direction.EAST)
                .mesh(mesh)
                .build();
        assertEquals(except, coordinateActual);
    }

    @Test
    public void should_outBoundsException_when_MRMMRMRRMMM() {
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
