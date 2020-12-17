package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping("/rents")
    public ResponseEntity<Void> addRent(Rent rent) throws URISyntaxException {
        Long rentId = rentService.createRentEntityByRentAndGetId(rent);

        return ResponseEntity
                .created(new URI("rents/" + rentId))
                .build();
    }

}
