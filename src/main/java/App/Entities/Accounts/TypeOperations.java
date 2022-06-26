package App.Entities.Accounts;

public enum TypeOperations {
    DEPOSIT("Depósito"),
    WITHDRAW("Saque"),
    TRANSFER_SENT("T. Enviada"),
    TRANSFER_RECEIVED("T. Recebida");

    private final String operation;

    TypeOperations(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
