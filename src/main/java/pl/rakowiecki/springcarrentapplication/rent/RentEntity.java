package pl.rakowiecki.springcarrentapplication.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Rent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int carId;
    private int clientId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int rentDays;
    private BigDecimal rentalPrice;
}
