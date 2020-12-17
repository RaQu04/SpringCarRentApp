package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<RentEntity, Long> {
}
