package pl.rakowiecki.springcarrentapplication.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest {

    CarEntity audiA6 = new CarEntity(null,
            "Audi",
            "A6",
            2018,
            2.0,
            Color.BLACK,
            BigDecimal.valueOf(299.99));
    CarEntity alfaGiulietta = new CarEntity(
            null,
            "Alfa Romeo",
            "Giulietta",
            2012,
            2.0,
            Color.GREY,
            BigDecimal.valueOf(199.99));
    CarEntity fordFocus = new CarEntity(
            null,
            "Ford",
            "Focus",
            2002,
            1.8,
            Color.SILVER,
            BigDecimal.valueOf(99.99));

    @BeforeEach
    void setUp() {
        carRepository.saveAll(List.of(alfaGiulietta, fordFocus, audiA6));
    }

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldCreateClient() {
        //given
        carRepository.deleteAll();
        //when
        final ResponseEntity<Void> carResult = testRestTemplate.postForEntity("/cars", audiA6, Void.class);
        final List<CarEntity> all = carRepository.findAll();

        //then
        assertThat(carResult.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(all.size()).isEqualTo(1);


    }
}