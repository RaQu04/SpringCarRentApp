package pl.rakowiecki.springcarrentapplication.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTestMockito {

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

//    @BeforeEach
//    void setUp() {
//        carRepository.saveAll(List.of(alfaGiulietta, fordFocus, audiA6));
//    }

    @Mock
    private CarRepository carRepository;

    @Mock
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldCreateCarWithMock() {
        //given
//        final ResponseEntity<Void> voidResponseEntity = testRestTemplate.postForEntity("/cars", audiA6, Void.class);
        when(carRepository.findAll())
                .thenReturn(List.of(fordFocus, alfaGiulietta, audiA6));

        //when
        //then

        assertEquals(carRepository.findAll().size(), 3);
     }

}