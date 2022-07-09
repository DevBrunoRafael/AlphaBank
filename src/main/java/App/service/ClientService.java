package App.service;

import App.Entities.Customer.Client;
import App.service.repository.ClientRepository;

public class ClientService {

    private final ClientRepository repo = new ClientRepository();

    public boolean registerCustomer(Client client){
        return repo.insert(client);
    }

    public Client findByCpf(String cpf){
        return repo.search(cpf);
    }
}
