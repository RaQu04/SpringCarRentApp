package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping("/rents")
    public ResponseEntity<Void> addRent(@RequestBody Rent rent) throws URISyntaxException {
        Long rentId = rentService.createRentEntityByRentAndGetId(rent);

        return ResponseEntity
                .created(new URI("rents/" + rentId))
                .build();
    }

    @GetMapping("/rents")
    public List<RentEntity> getAllRents() {
        return rentService.getAllRents();
    }

}
