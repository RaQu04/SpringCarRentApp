package pl.rakowiecki.springcarrentapplication.client;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    final Client JAN_KOWALSKI = new Client(
            "Jan",
            "Kowalski",
            "Poznan",
            "1996, 4, 17");


    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldSaveClientToRepository() {

        //given
        final ResponseEntity<Void> voidResponseEntity = testRestTemplate.postForEntity("/clients", JAN_KOWALSKI, Void.class);

        //when
        List<ClientEntity> clientList = clientRepository.findAll();

        //then
        Assertions.assertThat(voidResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(clientList.size()).isEqualTo(1);
    }


}