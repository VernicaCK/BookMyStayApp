import java.util.HashMap;

abstract class Room {
    String type; int beds; double price;
    Room(String t,int b,double p){ type=t; beds=b; price=p; }
    abstract void show();
}

class Single extends Room { Single(){ super("Single",1,50); } void show(){ System.out.println(type+" - Beds:"+beds+", $"+price); } }
class DoubleRoom extends Room { DoubleRoom(){ super("Double",2,90); } void show(){ System.out.println(type+" - Beds:"+beds+", $"+price); } }
class Suite extends Room { Suite(){ super("Suite",3,150); } void show(){ System.out.println(type+" - Beds:"+beds+", $"+price); } }

// Search service (read-only)
class SearchService {
    Room[] rooms;
    HashMap<String,Integer> inventory;

    public SearchService(Room[] r, HashMap<String,Integer> inv){
        rooms = r; inventory = inv;
    }

    public void searchAvailableRooms(){
        System.out.println("=== Available Rooms ===");
        for(Room room : rooms){
            if(inventory.getOrDefault(room.type,0) > 0){
                room.show();
                System.out.println("Available: "+inventory.get(room.type)+"\n");
            }
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args){
        // Create room objects
        Room[] rooms = { new Single(), new DoubleRoom(), new Suite() };

        // Centralized inventory
        HashMap<String,Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 0); // Example: unavailable
        inventory.put("Suite", 2);

        // Read-only search
        SearchService search = new SearchService(rooms, inventory);
        search.searchAvailableRooms();
    }
}