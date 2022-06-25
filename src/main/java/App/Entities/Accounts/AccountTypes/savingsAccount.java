package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Entities.Accounts.Operations;
import App.Entities.Customer.Client;
import App.Support.GenerateId;

public class savingsAccount extends Account implements Operations {

    private double juros = 0;

//   constructor ================================================================================================
    public savingsAccount(Client client) {
        super(GenerateId.getInstance().gerarId(0), client);
    }
//  =============================================================================================================


//   operations =================================================================================================

    public void earnInterest(){
        // implementar
    }

    @Override
    public void generateExtract()throws Exception {
        // implementar
    }
//  =============================================================================================================



    public double getJuros() {
        return juros;
    }
    public void setJuros(double juros) {
        this.juros = juros;
    }
}