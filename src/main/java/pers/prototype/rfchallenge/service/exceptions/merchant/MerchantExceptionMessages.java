package pers.prototype.rfchallenge.service.exceptions.merchant;

//TODO write messages in a file instead of ENUM
public enum MerchantExceptionMessages {
    NO_MERCHANTS_FOUND("DB contains no merchants"),
    NO_MERCHANT_FOUND("No merchant found in DB with ID: ");

    private String message;

    MerchantExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
