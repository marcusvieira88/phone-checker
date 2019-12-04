package tech.marcusvieira.phonechecker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;

@Data
@AllArgsConstructor
public class Filter {

    private Country country;
    private PhoneStatus status;
}
