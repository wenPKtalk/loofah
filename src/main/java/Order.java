import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Order {
    LEFT("L"),RIGHT("R"),MOVE("M");
    @Getter
    private final String order;
}
