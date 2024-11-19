import org.CS5800.MessageMemento;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageMementoTest {

    @Test
    void testMessageMementoStoresContentAndTimestamp() {
        LocalDateTime timestamp = LocalDateTime.now();
        MessageMemento memento = new MessageMemento("Hello, World!", timestamp);

        assertEquals("Hello, World!", memento.getContent(), "Content should be stored correctly.");
        assertEquals(timestamp, memento.getTimestamp(), "Timestamp should be stored correctly.");
    }
}
