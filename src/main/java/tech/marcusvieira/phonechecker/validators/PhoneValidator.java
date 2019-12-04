package tech.marcusvieira.phonechecker.validators;

import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;

public class PhoneValidator {

    /**
     * Validates phone based on {@link Country} and {@code phone}.
     *
     * @param country - customer country.
     * @param phone   - customer phone.
     * @return {@link PhoneStatus#VALID} if valid phone, {@link PhoneStatus#INVALID} otherwise.
     */
    public static PhoneStatus isValid(Country country, String phone) {
        if (country != null && phone != null && phone.matches(country.getRegexPhone())) {
            return PhoneStatus.VALID;
        }
        return PhoneStatus.INVALID;
    }
}
