package App.repository.service;

import App.Entities.Accounts.Account;
import App.repository.AccountRepository;

public class AccountService {

    public boolean registerAccount(Account account){
        return AccountRepository.insert(account);
    }

    public Account findByNumber(String number){
        return AccountRepository.search(number);
    }

    public boolean updateBalance(Account account){
        return AccountRepository.update(account);
    }

}
