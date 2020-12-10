package pl.rakowiecki.springcarrentapplication.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllById(Long id);

    List<CarEntity> findAllByBrand(String brand);

    List<CarEntity> findAllByModel(String model);

    List<CarEntity> findAllByYearOfProduction(int year);

    List<CarEntity> findAllByColor(Color color);

    List<CarEntity> findAllByPricePerDay(BigDecimal price);

    List<CarEntity> findAllByOrderByPricePerDayAsc();
}
