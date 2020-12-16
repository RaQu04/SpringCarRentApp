package pl.rakowiecki.springcarrentapplication.employe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findAllByLevel (Level level);
    List<EmployeeEntity> findAllByName (String name);
    List<EmployeeEntity> findAllBySurname (String surname);
}
