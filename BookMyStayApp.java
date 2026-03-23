import java.util.*;

// Room Domain Model
class Room {
    private String type;
    private double price;
    private List<String> amenities;

    public Room(String type, double price, List<String> amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: ₹" + price);
        System.out.println("Amenities: " + amenities);
        System.out.println("-----------------------------");
    }
}

// Inventory (State Holder)
class Inventory {
    private Map<String, Integer> availabilityMap = new HashMap<>();

    public void addRoom(String type, int count) {
        availabilityMap.put(type, count);
    }

    // Read-only access
    public int getAvailability(String type) {
        return availabilityMap.getOrDefault(type, 0);
    }

    public Set<String> getAllRoomTypes() {
        return availabilityMap.keySet();
    }
}

// Search Service (Read-only logic)
class SearchService {
    private Inventory inventory;
    private Map<String, Room> roomMap;

    public SearchService(Inventory inventory, Map<String, Room> roomMap) {
        this.inventory = inventory;
        this.roomMap = roomMap;
    }

    public void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:\n");

        for (String type : inventory.getAllRoomTypes()) {

            int available = inventory.getAvailability(type);

            // Validation Logic: filter unavailable rooms
            if (available > 0) {
                Room room = roomMap.get(type);

                if (room != null) { // Defensive Programming
                    room.displayDetails();
                    System.out.println("Available Count: " + available);
                    System.out.println("=============================");
                }
            }
        }
    }
}

// Main Class
public class BookMyStayApp {
    public static void main(String[] args) {

        // Inventory Setup
        Inventory inventory = new Inventory();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 0);
        inventory.addRoom("Suite", 3);

        // Room Details Setup (Domain Model)
        Map<String, Room> roomMap = new HashMap<>();

        roomMap.put("Single", new Room(
                "Single", 2000,
                Arrays.asList("WiFi", "TV", "AC")));

        roomMap.put("Double", new Room(
                "Double", 3500,
                Arrays.asList("WiFi", "TV", "AC", "Mini Bar")));

        roomMap.put("Suite", new Room(
                "Suite", 6000,
                Arrays.asList("WiFi", "TV", "AC", "Jacuzzi", "Balcony")));

        // Search Service
        SearchService searchService = new SearchService(inventory, roomMap);

        // Guest initiates search
        searchService.searchAvailableRooms();
    }
}