package pl.rakowiecki.springcarrentapplication.client;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Long addClient(Client client) {
        final ClientEntity clientEntity = clientRepository.save(new ClientEntity(null, client.getName(), client.getSurname(), client.getCity(), client.getBorn()));
        return clientEntity.getId();
    }
}
