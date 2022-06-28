package App.Entities.Accounts;

public enum TypeOperations {
    DEPOSIT("Depósito"),
    WITHDRAW("Saque"),
    TRANSFER_SENT("Transf. Enviada"),
    TRANSFER_RECEIVED("Transf. Recebida");

    private final String operation;

    TypeOperations(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
