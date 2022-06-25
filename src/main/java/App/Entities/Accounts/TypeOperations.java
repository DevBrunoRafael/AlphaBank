package App.Entities.Accounts;

public enum TypeOperations {
    DEPOSIT(1),
    WITHDRAW(2),
    TRANSFER(3);

    private final Integer operation;

    TypeOperations(int operation){
        this.operation = operation;
    }

    public Integer getOperation() {
        return operation;
    }
}
