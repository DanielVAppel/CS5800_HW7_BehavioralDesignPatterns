package org.CS5800;

import java.util.List;

public class User {
    private final String name;
    private final ChatHistory chatHistory = new ChatHistory();
    private final ChatServer chatServer;
    private MessageMemento lastMessage;

    public User(String name, ChatServer chatServer) {
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String recipient, String content) {
        Message message = new Message(name, recipient, content);
        chatServer.sendMessage(message);
        chatHistory.addMessage(message);
        lastMessage = new MessageMemento(content, message.getTimestamp());
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
    }

    public void undoLastMessage() {
        if (lastMessage != null) {
            // Find the most recent message sent by the user and remove it
            List<Message> messages = chatHistory.getMessages();
            for (int i = messages.size() - 1; i >= 0; i--) {
                Message message = messages.get(i);
                // Compare based on sender, content, and timestamp
                if (message.getSender().equals(name) &&
                        message.getContent().equals(lastMessage.getContent()) &&
                        message.getTimestamp().equals(lastMessage.getTimestamp())) {

                    messages.remove(i); // Remove the matched message
                    System.out.println(name + " undone message: " + lastMessage.getContent());
                    lastMessage = null; // Clear memento after removal
                    return; // Exit once the message is removed
                }
            }

            System.out.println(name + " has no matching message to undo.");
        } else {
            System.out.println(name + " has no message to undo.");
        }
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }
}

