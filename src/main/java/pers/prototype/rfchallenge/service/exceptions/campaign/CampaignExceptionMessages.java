package pers.prototype.rfchallenge.service.exceptions.campaign;

//TODO write messages in a file instead of ENUM
public enum CampaignExceptionMessages {
    NO_CAMPAIGNS_FOUND("DB contains no campaigns"),
    NO_CAMPAIGNS_BUDGET_LEFT("DB contains no merchants with available budget"),
    NO_CAMPAIGN_FOUND_BY_ID("Unable to find campaign with ID: "),
    NOT_ENOUGH_BUDGET("Not enough budget left to perform operation");

    private String message;

    CampaignExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
