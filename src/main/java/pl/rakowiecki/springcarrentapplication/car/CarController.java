package pl.rakowiecki.springcarrentapplication.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @PostMapping("cars")
    public ResponseEntity<Void> addCar(@RequestBody Car car) {
        return null;
        //TODO
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return null;
        //TODO
    }

    @GetMapping("/cars")
    public List<Car> getAllCars () {
        return null;
        //TODO
    }



}
