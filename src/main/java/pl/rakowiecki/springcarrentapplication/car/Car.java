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

    public static Car fromCarEntity(CarEntity carEntity) {
        return new Car(
                carEntity.getBrand(),
                carEntity.getModel(),
                carEntity.getYearOfProduction(),
                carEntity.getEngineSize(),
                carEntity.getColor(),
                carEntity.getPricePerDay());
    }
}
