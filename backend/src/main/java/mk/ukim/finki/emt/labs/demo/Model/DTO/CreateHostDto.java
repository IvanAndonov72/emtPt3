package mk.ukim.finki.emt.labs.demo.Model.DTO;

import lombok.Data;

@Data
public class CreateHostDto {
    private String name;        // Host's first name
    private String surname;     // Host's last name
    private String country;     // Host's country of residence
}
