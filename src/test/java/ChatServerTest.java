import org.CS5800.ChatServer;
import org.CS5800.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatServerTest {

    @Test
    void testRegisterAndUnregisterUser() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);

        assertTrue(chatServer.users.containsKey("Alice"));

        chatServer.unregisterUser(alice);
        assertFalse(chatServer.users.containsKey("Alice"));
    }

    @Test
    void testSendMessage() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("Bob", "Hello Bob!");
        assertEquals("Hello Bob!", bob.getChatHistory().getLastMessage().getContent());
    }

    @Test
    void testBlockUser() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User charlie = new User("Charlie", chatServer);

        chatServer.blockUser("Charlie", "Alice");

        alice.sendMessage("Charlie", "Are you there?");
        assertNull(charlie.getChatHistory().getLastMessage());
    }
}
