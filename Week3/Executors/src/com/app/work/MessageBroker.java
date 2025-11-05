package com.app.work;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

class MessageBroker {
    private final ConcurrentHashMap<String, ChatRoom> rooms = new ConcurrentHashMap<>();

    public void createRoom(String name) {
        rooms.putIfAbsent(name, new ChatRoom(name));
    }

    public void sendMessage(String room, String sender, String content) {
        rooms.computeIfAbsent(room, ChatRoom::new).postMessage(new Message(sender, content, room));
    }

    public Collection<ChatRoom> getAllRooms() {
        return rooms.values();
    }
}