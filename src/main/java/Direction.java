import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Direction  {
    NORTH("N"),SOUTH("S"),WEST("W"),EAST("E"),;

    @Getter
    private final String direction;

}
