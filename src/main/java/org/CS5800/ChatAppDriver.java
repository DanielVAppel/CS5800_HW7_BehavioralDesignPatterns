package org.CS5800;

public class ChatAppDriver {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);
        User charlie = new User("Charlie", chatServer);

        alice.sendMessage("Bob", "Hello Bob!");
        bob.sendMessage("Alice", "Hi Alice!");
        charlie.sendMessage("Bob", "Hey Bob!");

        System.out.println("--- Chat History for Bob ---");
        for (Message message : bob.getChatHistory()) {
            System.out.println(message);
        }

        System.out.println("\nAlice undoes her last message:");
        alice.undoLastMessage();

        System.out.println("\nCharlie blocks Alice and sends another message:");
        chatServer.blockUser("Charlie", "Alice");
        charlie.sendMessage("Alice", "Alice, are you there?");

        System.out.println("\n--- Iterating Through Alice's Chat History ---");
        for (Message message : alice.getChatHistory()) {
            System.out.println(message);
        }
    }
}

