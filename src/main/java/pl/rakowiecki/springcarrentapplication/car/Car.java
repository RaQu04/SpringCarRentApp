package pl.rakowiecki.springcarrentapplication.car;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Car {

    String brand;
    String model;
    int yearOfProduction;
    double engineSize;
    Color color;
    BigDecimal pricePerDay;
}
