package org.CS5800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChatServer {
    public final Map<String, User> users = new HashMap<>();
    private final Map<String, Set<String>> blockedUsers = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
        blockedUsers.put(user.getName(), new HashSet<>());
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
        blockedUsers.remove(user.getName());
    }

    public void blockUser(String blocker, String blockee) {
        if (blockedUsers.containsKey(blocker)) {
            blockedUsers.get(blocker).add(blockee);
        }
    }

    public void sendMessage(Message message) {
        String recipient = message.getRecipient();
        if (users.containsKey(recipient) && !blockedUsers.get(recipient).contains(message.getSender())) {
            users.get(recipient).receiveMessage(message);
        }
    }
}
