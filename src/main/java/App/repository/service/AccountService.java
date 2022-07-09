package App.repository.service;

import App.Entities.Accounts.Account;
import App.repository.AccountRepository;

public class AccountService {

    private final AccountRepository repo = new AccountRepository();

    public boolean registerAccount(Account account){
        return repo.insert(account);
    }

    public Account findByNumber(String number){
        return repo.search(number);
    }

    public boolean updateBalance(Account account){
        return repo.update(account);
    }

}
