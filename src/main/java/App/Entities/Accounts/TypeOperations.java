package App.Entities.Accounts;

public enum TypeOperations {
    DEPOSIT("DPS"),
    WITHDRAW("SAQ"),
    TRANSFER_SENT("TEV"),
    TRANSFER_RECEIVED("TRC");

    private final String operation;

    TypeOperations(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
