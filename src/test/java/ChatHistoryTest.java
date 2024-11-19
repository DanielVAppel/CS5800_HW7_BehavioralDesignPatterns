import org.CS5800.ChatHistory;
import org.CS5800.Message;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ChatHistoryTest {

    @Test
    void testAddMessage() {
        ChatHistory history = new ChatHistory();
        Message message = new Message("Alice", "Bob", "Hello Bob!");
        history.addMessage(message);

        assertEquals(1, history.getMessages().size());
        assertEquals(message, history.getMessages().get(0));
    }

    @Test
    void testIterator() {
        ChatHistory history = new ChatHistory();
        history.addMessage(new Message("Alice", "Bob", "Hello Bob!"));
        history.addMessage(new Message("Bob", "Alice", "Hi Alice!"));

        Iterator<Message> iterator = history.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Hello Bob!", iterator.next().getContent());
        assertTrue(iterator.hasNext());
        assertEquals("Hi Alice!", iterator.next().getContent());
        assertFalse(iterator.hasNext());
    }
}

