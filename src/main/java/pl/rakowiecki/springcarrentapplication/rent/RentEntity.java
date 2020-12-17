package pl.rakowiecki.springcarrentapplication.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rakowiecki.springcarrentapplication.car.CarEntity;
import pl.rakowiecki.springcarrentapplication.client.ClientEntity;

import javax.persistence.*;
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

    @OneToOne
    private CarEntity car;

    @OneToOne
    private ClientEntity client;

    private LocalDate rentDate;
    private LocalDate returnDate;
    private int rentDays;
    private BigDecimal rentalPrice;


}
