package pl.rakowiecki.springcarrentapplication.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        clientRepository.deleteAll();
        final ClientEntity clientOlivia = new ClientEntity(null, "Oliwia", "Spławska", "Poznań");
        final ClientEntity clientLukasz = new ClientEntity(null, "Lukasz", "Rakowiecki", "Leszno");
        final ClientEntity clientKrzysztof = new ClientEntity(null, "Krzysztof", "Krawczyk", "Warszawa");
        clientRepository.saveAll(List.of(clientOlivia, clientLukasz, clientKrzysztof));
    }

    @Test
    void shouldFindAllClient() {
        //when
        final List<ClientEntity> allClient = clientRepository.findAll();

        //then
        assertThat(allClient.size()).isEqualTo(3);
    }

    @Test
    void shouldFindClientById() {
        //when
        final Optional<ClientEntity> clientById = clientRepository.findById(1L);

        //then
        clientById.ifPresent(clientEntity -> assertThat(clientEntity.getId()).isEqualTo(1L));
    }

    @Test
    void shouldFindClientByName() {
        //when
        final List<ClientEntity> result = clientRepository.findAllByName("Lukasz");

        //then
        final ClientEntity clientEntity = result.get(0);
        assertThat(clientEntity.getName()).isEqualTo("Lukasz");
        assertThat(clientEntity.getSurname()).isEqualTo("Rakowiecki");
        assertThat(clientEntity.getCity()).isEqualTo("Leszno");
    }

    @Test
    void shouldFindClientsBySurname() {
        //when
        final List<ClientEntity> krawczykSurname = clientRepository.findAllBySurname("Krawczyk");

        //then
        assertThat(krawczykSurname.get(0).getSurname()).isEqualTo("Krawczyk");
    }

    @Test
    void shouldFindClientsByCity () {
        //when
        final List<ClientEntity> findByCity = clientRepository.findAllByCity("Poznań");

        //then
        assertThat(findByCity.get(0).getCity()).isEqualTo("Poznań");
    }

}