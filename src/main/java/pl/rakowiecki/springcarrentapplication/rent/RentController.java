package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }


}
