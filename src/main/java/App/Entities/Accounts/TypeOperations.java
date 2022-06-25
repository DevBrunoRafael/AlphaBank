package App.Entities.Accounts;

public enum TypeOperations {
    DEPOSIT("Depósito"),
    WITHDRAW("Saque"),
    TRANSFER_SENT("Transferência enviada"),
    TRANSFER_RECEIVED("Transferência recebida");

    private final String operation;

    TypeOperations(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
