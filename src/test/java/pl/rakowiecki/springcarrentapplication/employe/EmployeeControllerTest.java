package pl.rakowiecki.springcarrentapplication.employe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    public static final EmployeeEntity EMPLOYEE_ENTITY_JUNIOR = new EmployeeEntity(
            null,
            "John",
            "Travolta",
            Level.JUNIOR
    );

    public static final EmployeeEntity EMPLOYEE_ENTITY_CEO = new EmployeeEntity(
            null,
            "Sylwester",
            "Stalone",
            Level.CEO
    );

    public static final Employee EMPLOYEE_JAN = new Employee(
            "Janek",
            "Tester",
            Level.SENIOR
    );

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp() {
        employeeRepository.deleteAll();

        employeeRepository.saveAll(List.of(EMPLOYEE_ENTITY_JUNIOR, EMPLOYEE_ENTITY_CEO));

    }

    @Test
    void shouldSaveEmployeeToRepository() {
        //given
        final ResponseEntity<Void> voidResponseEntity = testRestTemplate.postForEntity("/employees", EMPLOYEE_JAN, Void.class);

        //when
        final List<EmployeeEntity> employeeList = employeeRepository.findAll();

        //then
        assertThat(voidResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(employeeList.size()).isEqualTo(1);
    }

    @Test
    void shouldReturnEmployeeByJuniorLevel() {
        //when
        final List<EmployeeEntity> allByLevel = employeeRepository.findAllByLevel(Level.JUNIOR);

        //then
        assertThat(allByLevel.size()).isEqualTo(1);
    }

    @Test
    void shouldReturnEmployeeById() {
        //when
        final Optional<EmployeeEntity> byId = employeeRepository.findById(1L);

        //then
        assertThat(byId.get().getName()).isEqualTo("John");
     }



}