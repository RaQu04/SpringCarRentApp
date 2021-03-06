package pl.rakowiecki.springcarrentapplication.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Long createClientEntityFromClientAndGetId(Client client) {
        final ClientEntity clientEntity = clientRepository.save(new ClientEntity(null, client.getName(), client.getSurname(), client.getCity()));
        return clientEntity.getId();
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id)
                .map(Client::fromClientEntity);
    }

    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }
}
