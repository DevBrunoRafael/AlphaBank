package App.repository.service;

import App.Entities.Customer.Client;
import App.repository.ClientRepository;

public class ClientService {
    public boolean registerCustomer(Client client){
        return ClientRepository.insert(client);
    }

    public Client findByCpf(String cpf){
        return ClientRepository.search(cpf);
    }
}
