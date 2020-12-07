package pl.rakowiecki.springcarrentapplication.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CarRepositoryTest {

    CarEntity alfaGiulietta = new CarEntity(
            null,
            "Alfa Romeo",
            "Giulietta",
            2012,
            2.0,
            Color.GREY,
            BigDecimal.valueOf(199.99));

    CarEntity audiA6 = new CarEntity(
            null,
            "Audi",
            "A6",
            2018,
            2.0,
            Color.BLACK,
            BigDecimal.valueOf(399.99));

    CarEntity fordFocus = new CarEntity(
            null,
            "Ford",
            "Focus",
            2002,
            1.8,
            Color.SILVER,
            BigDecimal.valueOf(99.99));


    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository.saveAll(List.of(alfaGiulietta, audiA6, fordFocus));
    }

    @Test
    void shouldFindCarById() {
        //when
        final List<CarEntity> allById = carRepository.findAllById(1L);

        //then
        assertThat(allById.get(0).getId()).isEqualTo(1);
    }

    @Test
    void shouldFindCarByBrand() {
        //when
        final List<CarEntity> result = carRepository.findAllByBrand("Ford");

        //then
        assertThat(result.get(0).getBrand()).isEqualTo("Ford");

    }

    @Test
    void shouldFindCarByModel() {
        //when
        final List<CarEntity> result = carRepository.findAllByModel("Giulietta");

        //then
        assertThat(result.get(0).getModel()).isEqualTo("Giulietta");
    }

    @Test
    void shouldFindCarByYearOfProduction() {
        //when
        final List<CarEntity> result = carRepository.findAllByYearOfProduction(2018);

        //then
        assertThat(result.get(0).getYearOfProduction()).isEqualTo(2018);
    }

    @Test
    void shouldFindCarByColor() {
        //when
        final List<CarEntity> allByColor = carRepository.findAllByColor(Color.SILVER);

        //then
        assertThat(allByColor.get(0).getColor()).isEqualTo(Color.SILVER);
    }

    @Test
    void shouldFindCarsByPriceByAsc() {
        //when
        final List<CarEntity> allByOrderByPricePerDayAsc = carRepository.findAllByOrderByPricePerDayAsc();

        //then
        allByOrderByPricePerDayAsc.forEach(System.out::println);
        assertThat(allByOrderByPricePerDayAsc.get(0).getModel()).isEqualTo("Focus");
    }

    @Test
    void shouldFindCarByPrice() {
        //when
        final List<CarEntity> allByPricePerDay = carRepository.findAllByPricePerDay(BigDecimal.valueOf(199.99));

        //then
        assertThat(allByPricePerDay.get(0).getPricePerDay()).isEqualTo(BigDecimal.valueOf(199.99));

    }
}