package org.CS5800;

import java.time.LocalDateTime;

public class Message {
    private final String sender;
    private final String recipient;
    private final LocalDateTime timestamp;
    private final String content;

    public Message(String sender, String recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.timestamp = LocalDateTime.now();
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + " -> " + recipient + ": " + content;
    }
}
