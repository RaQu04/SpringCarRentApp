package pl.rakowiecki.springcarrentapplication.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("cars")
    public ResponseEntity<Void> addCar(@RequestBody Car car) throws URISyntaxException {

        Long carId = carService.createCarEntityByCarAndGetId(car);

        return ResponseEntity
                .created(new URI("/cars/" + carId))
                .build();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carService.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return null;
        //TODO
    }

}
