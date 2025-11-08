package LL;

public class LinkedListDemo {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.println("Linked List Contents:");
        Node current = head;
        while (current != null) {
            System.out.println("Node Data: " + current.data);
            current = current.next;
        }
    }
}