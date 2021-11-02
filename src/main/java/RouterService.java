import lombok.Builder;

import java.util.List;

public class RouterService {

    @Builder
    public RouterService() {
    }

    public Coordinate findCoordinate(final Coordinate coordinate,
                                     final List<CommandStrategy> commandStrategies) {
        commandStrategies.forEach(commandStrategy -> commandStrategy.moveStrategy(coordinate));
        return coordinate;
    }
}
