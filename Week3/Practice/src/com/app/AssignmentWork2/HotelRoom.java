package com.app.AssignmentWork2;

class HotelRoom {
    private final Object roomLock = new Object();
    private final Object paymentLock = new Object();
    private boolean booked = false;

    public void bookRoom(String user) {
        synchronized (roomLock) { // Always lock room first
            System.out.println(user + " acquired room lock.");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            
            synchronized (paymentLock) { // Then lock payment
                System.out.println(user + " acquired payment lock.");
                if (!booked) {
                    booked = true;
                    System.out.println(user + " successfully booked the room.");
                } else {
                    System.out.println(user + " tried to book, but room already booked.");
                }
            }
        }
    }
}
