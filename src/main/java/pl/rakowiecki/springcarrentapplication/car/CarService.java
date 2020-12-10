package pl.rakowiecki.springcarrentapplication.car;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long createCarEntityByCarAndGetId(Car car) {
        final CarEntity carEntity = carRepository.save(new CarEntity(null, car.getBrand(), car.getModel(), car.getYearOfProduction(), car.getEngineSize(), car.getColor(), car.getPricePerDay()));

        return carEntity.getId();
    }

    public Optional<Car> getClient(Long id) {
        return carRepository.findById(id)
                .map(Car::fromCarEntity);
    }
}
