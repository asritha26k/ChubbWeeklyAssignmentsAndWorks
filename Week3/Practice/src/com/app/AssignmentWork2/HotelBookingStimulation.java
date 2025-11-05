package com.app.AssignmentWork2;

public class HotelBookingStimulation {
    public static void main(String[] args) {
        HotelRoom room = new HotelRoom();

        Runnable user1 = () -> room.bookRoom("User 1");
        Runnable user2 = () -> room.bookRoom("User 2");

        Thread t1 = new Thread(user1);
        Thread t2 = new Thread(user2);

        t1.start();
        t2.start();
    }
}
