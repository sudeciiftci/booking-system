public class Payment {
    private int paymentId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int paymentId, double amount, String paymentMethod, String paymentStatus){
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }

    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    void processPayment(){

    }
}
