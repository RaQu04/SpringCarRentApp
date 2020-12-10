package pl.rakowiecki.springcarrentapplication.client;

import lombok.Value;

@Value
public class Client {

    String name;
    String surname;
    String city;

    public static Client fromClientEntity(ClientEntity clientEntity) {
        return new Client(clientEntity.getName(), clientEntity.getSurname(), clientEntity.getCity());
    }
}
