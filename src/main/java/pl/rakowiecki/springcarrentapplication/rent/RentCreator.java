package pl.rakowiecki.springcarrentapplication.rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class RentCreator {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long carId;
    Long clientId;
    LocalDate rentDate;
    LocalDate returnDate;
    int rentDays;
    BigDecimal rentalPrice;

}
