abstract class Room {
    String type; int beds; double price;
    Room(String t,int b,double p){ type=t; beds=b; price=p; }
    abstract void show();
}

class Single extends Room { Single(){ super("Single",1,50); } void show(){ System.out.println(type+" - Beds:"+beds+", $"+price); } }
class DoubleRoom extends Room { DoubleRoom(){ super("Double",2,90); } void show(){ System.out.println(type+" - Beds:"+beds+", $"+price); } }
class Suite extends Room { Suite(){ super("Suite",3,150); } void show(){ System.out.println(type+" - Beds:"+beds+", $"+price); } }

public class BookMyStayApp {
    public static void main(String[] args){
        Room[] rooms = { new Single(), new DoubleRoom(), new Suite() };
        int[] avail = {5,3,2};
        System.out.println("=== BookMyStay v2.1 ===");
        for(int i=0;i<rooms.length;i++){
            rooms[i].show();
            System.out.println("Available: "+avail[i]+"\n");
        }
    }
}