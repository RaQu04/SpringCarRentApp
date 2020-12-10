package pl.rakowiecki.springcarrentapplication.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/clients")
    public ResponseEntity<Void> addClient(@RequestBody Client client) throws URISyntaxException {
        Long clientId = clientService.createClientEntityFromClientAndGetId(client);

        return ResponseEntity
                .created(new URI("/clients/" + clientId))
                .build();

    }

    @GetMapping("/clients")
    public List<Client> getAllClient() {
        return clientService.getClients();
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
