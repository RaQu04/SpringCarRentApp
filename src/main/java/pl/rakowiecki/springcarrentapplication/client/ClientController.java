package pl.rakowiecki.springcarrentapplication.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        Long clientId = clientService.addClient(client);

        return ResponseEntity
                .created(new URI("/clients/" + clientId))
                .build();

    }

}
