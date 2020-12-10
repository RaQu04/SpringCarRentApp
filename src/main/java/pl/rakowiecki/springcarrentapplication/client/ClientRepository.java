package pl.rakowiecki.springcarrentapplication.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    List<ClientEntity> findAllByName (String name);
    List<ClientEntity> findAllBySurname (String surname);
    List<ClientEntity> findAllByCity (String city);
}
