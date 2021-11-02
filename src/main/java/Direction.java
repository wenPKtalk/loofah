import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Direction  {
    NORTH(0, 1){
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return WEST;
        }
    },
    SOUTH(0, -1) {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }
    },
    WEST(-1, 0) {
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }
    },
    EAST(1, 0) {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }
    },;

    @Getter
    private final int stepSizeOnXAxis;
    @Getter
    private final int stepSizeOnYAxis;

    public abstract Direction right();
    public abstract Direction left();
}
