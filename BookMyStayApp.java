
import java.util.*;

// Reservation (Represents booking intent)
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

// Booking Request Queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request (enqueue)
    public void addRequest(Reservation reservation) {
        if (reservation != null) { // Defensive Programming
            queue.add(reservation);
            System.out.println("Request Added: ");
            reservation.display();
            System.out.println("--------------------------");
        }
    }

    // View all requests (without removing)
    public void viewRequests() {
        System.out.println("\nCurrent Booking Queue:\n");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }
    }

    // Get next request (for future processing, no removal here if you want strict read)
    public Reservation peekNextRequest() {
        return queue.peek();
    }
}

// Main Class
public class BookMyStayApp {
    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulating multiple guest requests
        Reservation r1 = new Reservation("Alice", "Single");
        Reservation r2 = new Reservation("Bob", "Suite");
        Reservation r3 = new Reservation("Charlie", "Single");
        Reservation r4 = new Reservation("Diana", "Suite");

        // Guest submits booking requests
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        bookingQueue.addRequest(r4);

        // View queue (FIFO order preserved)
        bookingQueue.viewRequests();


        // Peek next request (who gets processed first)
        System.out.println("\nNext Request to Process (FIFO):");
        Reservation next = bookingQueue.peekNextRequest();
        if (next != null) {
            next.display();

        roomMap.put("Suite", new Room(
                "Suite", 6000,
                Arrays.asList("WiFi", "TV", "AC", "Jacuzzi", "Balcony")));

        // Search Service
        SearchService searchService = new SearchService(inventory, roomMap);

        // Guest initiates search
        searchService.searchAvailableRooms();

import java.util.HashMap;

public class BookMyStayApp {
    public static void main(String[] args) {
        // Initialize inventory
        HashMap<String,Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Display inventory
        System.out.println("=== BookMyStay v3.1 ===");
        System.out.println("Room Inventory:");
        for(String room : inventory.keySet()) {
            System.out.println(room + " Rooms Available: " + inventory.get(room));
        }

        // Update example
        inventory.put("Double", 2);
        System.out.println("\nAfter updating Double Room availability:");
        for(String room : inventory.keySet()) {
            System.out.println(room + " Rooms Available: " + inventory.get(room));

        }
    }
}