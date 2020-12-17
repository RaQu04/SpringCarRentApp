package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.stereotype.Service;
import pl.rakowiecki.springcarrentapplication.car.CarEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Long createRentEntityByRentAndGetId(Rent rent) {
        final RentEntity rentEntity = rentRepository.save(new RentEntity(
                null,
                rent.getCar(),
                rent.getClient(),
                rent.getRentDate(),
                rent.getReturnDate(),
                rent.getRentDays(),
                rent.getRentalPrice()
        ));

        return rentEntity.getId();
    }

    public List<RentEntity> getAllRents() {
        return rentRepository.findAll();
    }
}
