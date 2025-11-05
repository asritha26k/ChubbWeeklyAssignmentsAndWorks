package com.app.work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ChatRoom {
    private final String name;
    private final BlockingQueue<Message> messages = new LinkedBlockingQueue<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void postMessage(Message message) {
        messages.offer(message);
    }

    public List<Message> drainMessages() {
        List<Message> list = new ArrayList<>();
        messages.drainTo(list);
        return list;
    }
}