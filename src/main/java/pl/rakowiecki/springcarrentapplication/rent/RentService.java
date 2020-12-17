package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.stereotype.Service;

@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

}
