package App.Entities.Accounts.AccountTypes;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.Operations;
import App.Entities.Customer.Client;
import App.Support.Utilities;

public class savingsAccount extends Account implements Operations {

    private double interest = 0;

//   constructor ================================================================================================
    public savingsAccount(Client client) {
        super(Utilities.generateId(0), client);
    }
//  =============================================================================================================


//   operations =================================================================================================
    public void earnInterest(){
        // implementar
    }
//  =============================================================================================================


//  getters and setters =========================================================================================
    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }
//  =============================================================================================================




}