package pl.rakowiecki.springcarrentapplication.client;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerTest {

    public static final ClientEntity CLIENT_ENTITY_ADAM_NOWAK = new ClientEntity(
            null,
            "Adam",
            "Nowak",
            "Kalisz",
            "1997, 4, 12");
    public static final Client CLIENT_JAN_KOWALSKI = new Client(
            "Jan",
            "Kowalski",
            "Poznan",
            "1996, 4, 17");

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldSaveClientToRepository() {

        //given
        final ResponseEntity<Void> voidResponseEntity = testRestTemplate.postForEntity("/clients", CLIENT_JAN_KOWALSKI, Void.class);

        //when
        List<ClientEntity> clientList = clientRepository.findAll();

        //then
        Assertions.assertThat(voidResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(clientList.size()).isEqualTo(1);
    }

    @Test
    void shouldReturnClientWhenExistInRepository() {
        //given
        clientRepository.save(CLIENT_ENTITY_ADAM_NOWAK);

        //when
        ResponseEntity<Client> clientResult = testRestTemplate.getForEntity("/clients/1", Client.class);

        //then
        assertThat(clientResult.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(clientResult.getBody()).isNotNull();
    }


}