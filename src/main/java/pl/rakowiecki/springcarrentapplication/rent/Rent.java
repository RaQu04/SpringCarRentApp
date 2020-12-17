package pl.rakowiecki.springcarrentapplication.rent;

import lombok.Value;
import pl.rakowiecki.springcarrentapplication.car.CarEntity;
import pl.rakowiecki.springcarrentapplication.client.ClientEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class Rent {

    CarEntity car;
    ClientEntity client;
    LocalDate rentDate;
    LocalDate returnDate;
    int rentDays;
    BigDecimal rentalPrice;
}
