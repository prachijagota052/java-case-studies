abstract class Plan{
    private String patientName;
    private double baseFee;
    Plan(String patientName, double baseFee){
        this.patientName = patientName;
        this.baseFee = baseFee;
    }
    String getPatientName(){
        return patientName;
    }
    double getBaseFee(){
        return baseFee;
    }
    void printInvoice(Plan p){
        System.out.println("Patient Name: " + p.getPatientName());
        System.out.println("Base Fee: $" + p.getBaseFee());
        System.out.println("Total Bill: $" + p.calculateBill());
    }
    abstract double calculateBill();
}

class SilverPlan extends Plan{
    SilverPlan(String patientName, double baseFee){
        super(patientName, baseFee);
    }
    @Override
    double calculateBill(){
        return getBaseFee() + 15; // Fixed fee for Silver Plan
    }
}

class GoldPlan extends Plan{
    GoldPlan(String patientName, double baseFee){
        super(patientName, baseFee);
    }
    @Override
    double calculateBill(){
        return getBaseFee() + (getBaseFee() * 0.1) - 20; 
    }
}

public class BillingEngine {
    public static void main(String[] args) {
        Plan silverPlan = new SilverPlan("John Doe", 100);
        Plan goldPlan = new GoldPlan("Jane Smith", 200);
        Plan goldPlan2 = new GoldPlan("Alice Brown", 50);
        silverPlan.printInvoice(silverPlan);
        goldPlan.printInvoice(goldPlan);
        goldPlan2.printInvoice(goldPlan2);
    }
}