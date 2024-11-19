import org.CS5800.ChatServer;
import org.CS5800.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testSendMessage() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("Bob", "Hello Bob!");
        assertEquals(1, bob.getChatHistory().getMessages().size());
        assertEquals("Hello Bob!", bob.getChatHistory().getMessages().get(0).getContent());
    }

    @Test
    void testUndoLastMessage() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);

        // Alice sends two messages
        alice.sendMessage("Bob", "Hello Bob!");
        alice.sendMessage("Bob", "How are you?");

        // Undo the last message ("How are you?")
        alice.undoLastMessage();

        // Assert that only "Hello Bob!" remains in the history
        assertEquals(1, alice.getChatHistory().getMessages().size(), "Chat history should have one message after undo.");
        assertEquals("Hello Bob!", alice.getChatHistory().getLastMessage().getContent(),
                "The remaining message should be 'Hello Bob!'.");
    }
}
