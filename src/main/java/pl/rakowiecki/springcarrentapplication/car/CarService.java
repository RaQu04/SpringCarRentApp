package pl.rakowiecki.springcarrentapplication.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long createCarEntityByCarAndGetId(Car car) {
        final CarEntity carEntity = carRepository.save(new CarEntity(
                null,
                car.getBrand(),
                car.getModel(),
                car.getYearOfProduction(),
                car.getEngineSize(),
                car.getColor(),
                car.getPricePerDay()
        ));

        return carEntity.getId();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id)
                .map(Car::fromCarEntity);
    }

    public Optional<CarEntity> getCarEntityById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll()
                .stream().map(Car::fromCarEntity)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findAllByBrand(brand).stream()
                .map(Car::fromCarEntity)
                .collect(Collectors.toList());
    }
}
