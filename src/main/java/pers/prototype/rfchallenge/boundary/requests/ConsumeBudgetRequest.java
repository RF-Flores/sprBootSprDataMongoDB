package pers.prototype.rfchallenge.boundary.requests;

public class ConsumeBudgetRequest {

    private String id;
    private double amount;

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public ConsumeBudgetRequest() {
    }

    public ConsumeBudgetRequest(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}
