import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FirstLoofahTest {

    @Test
    void should_say_hello() {
        FirstLoofah firstLoofah = new FirstLoofah();
        assertEquals(firstLoofah.sayHello(), "hello world");
    }
}