import org.CS5800.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testMessageStoresAttributes() {
        Message message = new Message("Alice", "Bob", "Hello, Bob!");

        assertEquals("Alice", message.getSender(), "Sender should be stored correctly.");
        assertEquals("Bob", message.getRecipient(), "Recipient should be stored correctly.");
        assertEquals("Hello, Bob!", message.getContent(), "Content should be stored correctly.");
        assertNotNull(message.getTimestamp(), "Timestamp should be initialized.");
    }

    @Test
    void testMessageToString() {
        Message message = new Message("Alice", "Bob", "Hello, Bob!");
        String expectedOutput = "[" + message.getTimestamp() + "] Alice -> Bob: Hello, Bob!";
        assertEquals(expectedOutput, message.toString(), "toString() should format the message correctly.");
    }
}

