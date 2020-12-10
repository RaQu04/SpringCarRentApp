package pl.rakowiecki.springcarrentapplication.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "Cars")
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String brand;
    String model;
    int yearOfProduction;
    double engineSize;
    @Enumerated(value = EnumType.STRING)
    Color color;
    BigDecimal pricePerDay;
}
