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