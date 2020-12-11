package pl.rakowiecki.springcarrentapplication.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/search")
    public List<Car> getCarsBySearch(@RequestParam(required = false) String brand,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) int yearOfProduction,
                                     @RequestParam(required = false) Color color,
                                     @RequestParam(required = false) BigDecimal pricePerDay) {
        if (brand == null) {
            return carService.getAllCars();
        } else {
            return carService.getCarsByBrand(brand);
        }

        //TODO - jak inaczej to zapisac bez IF
    }

}
