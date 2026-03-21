
interface RemoteControllable {
    abstract void connectToWifi();
}

interface PowerSaving {
    abstract void getEnergyRating();
}

abstract class Device{
    String brand;
    abstract void turnOn();
}

class SmartTV extends Device implements RemoteControllable, PowerSaving {
    SmartTV(String brand) {
        this.brand = brand;
    }
    @Override
    void turnOn() {
        System.out.println("Turning on " + brand + " Smart TV");
    }
    @Override
    public void connectToWifi() {
        System.out.println("Connecting " + brand + " Smart TV to WiFi");
    }
    @Override
    public void getEnergyRating() {
        System.out.println(brand + " Smart TV has an energy rating of A+");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
       Device d = new SmartTV("Sony"); 
        d.turnOn();
       RemoteControllable r = new SmartTV("LG");
        r.connectToWifi();
        //r.turnOn();


    }
}