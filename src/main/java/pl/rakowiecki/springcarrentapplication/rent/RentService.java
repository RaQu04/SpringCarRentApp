package pl.rakowiecki.springcarrentapplication.rent;

import org.springframework.stereotype.Service;
import pl.rakowiecki.springcarrentapplication.car.CarEntity;
import pl.rakowiecki.springcarrentapplication.car.CarService;
import pl.rakowiecki.springcarrentapplication.client.ClientEntity;
import pl.rakowiecki.springcarrentapplication.client.ClientService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final ClientService clientService;
    private final CarService carService;

    public RentService(RentRepository rentRepository, ClientService clientService, CarService carService) {
        this.rentRepository = rentRepository;
        this.clientService = clientService;
        this.carService = carService;
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

    public Optional<ClientEntity> getClientById(Long id) {
        return clientService.getClientEntityById(id);
    }

    public Optional<CarEntity> getCarById(Long id) {
        return carService.getCarEntityById(id);
    }

    public void createRentByRentCreator(RentCreator rentCreator) {

        RentEntity rentEntity = new RentEntity(
                null,
                getCarById(rentCreator.getCarId()),
                getClientById(rentCreator.getClientId()),
                null,
                null,
                1,
                BigDecimal.TEN
        );

        rentRepository.save(rentEntity);

        //TODO nie działa

    }

}
