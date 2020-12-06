package pl.rakowiecki.springcarrentapplication.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        clientRepository.deleteAll();
        final ClientEntity clientOlivia = new ClientEntity(null, "Oliwia", "Spławska", "Poznań");
        final ClientEntity clientLukasz = new ClientEntity(null, "Lukasz", "Rakowiecki", "Poznań");
        clientRepository.saveAll(List.of(clientOlivia, clientLukasz));
    }

    @Test
    void shouldFindAllClient() {
        //given
        //when
        final List<ClientEntity> allClient = clientRepository.findAll();

        //then
        assertThat(allClient.size()).isEqualTo(2);
    }

    @Test
    void shouldFindClientByName() {
        //when
        final List<ClientEntity> result = clientRepository.findAllByName("Lukasz");

        //then
        final ClientEntity clientEntity = result.get(0);
        assertThat(clientEntity.getName()).isEqualTo("Lukasz");
        assertThat(clientEntity.getSurname()).isEqualTo("Rakowiecki");
        assertThat(clientEntity.getCity()).isEqualTo("Poznań");
    }

}