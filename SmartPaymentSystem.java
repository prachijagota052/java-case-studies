abstract class Payment {
    private String transactionId;
    private double amount;
    Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
    String getTransactionId() {
        return this.transactionId;
    }
    double getAmount() {
        return this.amount;
    }
    abstract double processPayment();
}

class CreditCardPayment extends Payment {
    CreditCardPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }
    
    double processPayment() {
        double amount =getAmount() + (getAmount() * 0.02);
        
        System.out.println("Processing credit card payment of " + amount);
        return amount;
    }
}

class UPIPayment extends Payment {
    UPIPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }
    
    double processPayment() {
        
        System.out.println("Processing UPI payment of " + getAmount());
        return getAmount();
    }
}

public class SmartPaymentSystem {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment("txn001", 1000);
        creditCardPayment.processPayment();
        

        Payment upiPayment = new UPIPayment("txn002", 1000);
        upiPayment.processPayment();
        
        Payment[] p = new Payment[2];
        p[0] = creditCardPayment;
        p[1] = upiPayment;
        double amount = 0;
        for(Payment payment : p) {
            amount = amount + payment.processPayment();
        }
        System.out.println("Total amount processed: " + amount);
    }
}