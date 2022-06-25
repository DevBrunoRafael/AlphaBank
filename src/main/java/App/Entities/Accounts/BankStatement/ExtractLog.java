package App.Entities.Accounts.BankStatement;

public class ExtractLog {

    protected int numAccount;
    protected String date;
    protected String hours;
    protected int operation;
    protected String information;

    public ExtractLog() {
    }

    public ExtractLog(int numAccount, int operation, String information) {
        this.numAccount = numAccount;
        this.operation = operation;
        this.information = information;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}
