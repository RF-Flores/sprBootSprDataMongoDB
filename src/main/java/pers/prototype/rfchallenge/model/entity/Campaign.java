package pers.prototype.rfchallenge.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "campaign")
public class Campaign {
    @Id
    private String id;

    @Field(name = "budget")
    private double budget;

    @Field(name = "cashBackPercentage")
    private double cashBackPercentage;

    @Field(name = "purchaseMinThreshold")
    private double purchaseMinThreshold;

    @DBRef
    private Merchant merchant;

    public String getId() {
        return id;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getCashBackPercentage() {
        return cashBackPercentage;
    }

    public void setCashBackPercentage(double cashBackPercentage) {
        this.cashBackPercentage = cashBackPercentage;
    }

    public double getPurchaseMinThreshold() {
        return purchaseMinThreshold;
    }

    public void setPurchaseMinThreshold(double purchaseMinThreshold) {
        this.purchaseMinThreshold = purchaseMinThreshold;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Campaign() {
    }

    @PersistenceCreator
    public Campaign(double budget, double cashBackPercentage,
                    double purchaseMinThreshold, Merchant merchant) {
        this.budget = budget;
        this.cashBackPercentage = cashBackPercentage;
        this.purchaseMinThreshold = purchaseMinThreshold;
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return String.format(
                "Campaign{id = '%s', budget= '%s', cashbackPercentage = '%s', purchaseMinThreshold= '%s%%', %s",
                id,budget,cashBackPercentage,purchaseMinThreshold,merchant);
    }
}
