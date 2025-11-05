package com.app.work;



import java.util.*;
import java.util.concurrent.*;

// Represents a chat message
class Message {
    private final String sender;
    private final String content;
    private final String room;

    public Message(String sender, String content, String room) {
        this.sender = sender;
        this.content = content;
        this.room = room;
    }

    public String getSender() { return sender; }
    public String getContent() { return content; }
    public String getRoom() { return room; }

    @Override
    public String toString() {
        return "[" + room + "] " + sender + ": " + content;
    }
}




