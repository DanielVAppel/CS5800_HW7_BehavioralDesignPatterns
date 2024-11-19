package org.CS5800;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements Iterable<Message> {
    private final List<Message> history = new ArrayList<>();

    public void addMessage(Message message) {
        history.add(message);
    }

    public Message getLastMessage() {
        return history.isEmpty() ? null : history.get(history.size() - 1);
    }

    public List<Message> getMessages() {
        return new ArrayList<>(history);
    }

    @Override
    public Iterator<Message> iterator() {
        return history.iterator();
    }
}


