package pl.rakowiecki.springcarrentapplication.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

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

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return clientService.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
