abstract class Robot{
    private String batteryId;
    protected double chargeLevel;
    Robot(String batteryId, double chargeLevel){
        this.batteryId = batteryId;
        if(chargeLevel < 0 || chargeLevel > 100){
            throw new IllegalArgumentException("Charge level must be between 0 and 100.");
        }
        else{
            this.chargeLevel = chargeLevel;
        }
    }
    String getBatteryId(){
        return batteryId;
    }
    protected void work(double newChargeLevel){
        if(newChargeLevel < 0 || newChargeLevel > 100){
            throw new IllegalArgumentException("Charge level must be between 0 and 100.");
        }
        else{
            this.chargeLevel = newChargeLevel;
        }
    }
    abstract void performTask();

}

class DroneRobot extends Robot{
    DroneRobot(String batteryId, double chargeLevel){
        super(batteryId, chargeLevel);
    }
    @Override
    void performTask() {
        System.out.println("Drone is performing aerial surveillance.");
        work(this.chargeLevel - 15);
        System.out.println("Charge level after task: " + this.chargeLevel + "%"); // Consumes 10% of the charge level for each task
    }
}
class GroundRobot extends Robot{
    GroundRobot(String batteryId, double chargeLevel){
        super(batteryId, chargeLevel);
    }
    boolean surfaceCheck(){
        System.out.println("Performing surface check before delivery.");
        return true; // Assuming the surface check is always successful for simplicity
    }
    @Override
    void performTask() {
        if(this.surfaceCheck());
        {
            System.out.println("Ground robot is performing delivery.");
            work(this.chargeLevel -5); 
            System.out.println("Charge level after task: " + this.chargeLevel + "%");
        }
    }
}

public class WarehouseAutomation {
    public static void main(String[] args) {

        try {
        DroneRobot drone = new DroneRobot("DRN123", 20);
        drone.performTask();
        }
        catch(IllegalArgumentException e){
            System.out.println("Low Battery!");
        }
        try{
        GroundRobot groundRobot = new GroundRobot("GRD456", 10);
        groundRobot.performTask();
        }
        catch(IllegalArgumentException e){
            System.out.println("Low Battery!");
        }
        try{
        DroneRobot drone2 = new DroneRobot("DRN789", 10);
        drone2.performTask();
        }
        catch(IllegalArgumentException e){
            System.out.println("Low Battery!");
        }

    }
}