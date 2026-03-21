abstract class Transport {
    String trackingId;
    String destination;
    Transport(String trackingId, String destination) {
        this.trackingId = trackingId;
        this.destination = destination;
    }
    abstract void dispatch();
}

class Truck extends Transport {
    Truck(String trackingId, String destination) {
        super(trackingId, destination);
    }
    @Override
    void dispatch() {
        System.out.println("Dispatching truck to " + destination);
    }
}
interface GPS {
    abstract void getCoordinates();
}

interface Autonomous {
    abstract void selfNavigate();
}

class DeliveryDrone extends Transport implements GPS, Autonomous {
    DeliveryDrone(String trackingId, String destination) {
        super(trackingId, destination);
    }
    
    @Override
    void dispatch() {
        System.out.println("Dispatching drone to " + destination);
    }
    
    @Override
    public void getCoordinates() {
        System.out.println("Getting GPS coordinates for " + destination);
    }
    
    @Override
    public void selfNavigate() {
        System.out.println("Drone is navigating autonomously to " + destination);
    }
}

public class SmartLogisticsSystem {
    public static void main(String[] args) {
        Transport t = new DeliveryDrone("D101", "Warehouse B");
        t.dispatch();
        GPS g = new DeliveryDrone("D101", "Warehouse B");
        g.getCoordinates();
        if (t instanceof GPS) {
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        
    }
}