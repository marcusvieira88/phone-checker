package tech.marcusvieira.phonechecker.enums;

import lombok.Getter;

@Getter
public enum Country {

    CAMEROON("^\\(237\\).*$", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("^\\(251\\).*$", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("^\\(212\\).*$", "\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("^\\(258\\).*$", "\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("^\\(256\\).*$", "\\(256\\)\\ ?\\d{9}$");

    private String regexCode;
    private String regexPhone;

    Country(String regexCode, String regexPhone) {
        this.regexCode = regexCode;
        this.regexPhone = regexPhone;
    }

    /**
     * Returns country based on phone.
     *
     * @param phone - phone.
     * @return {@link Country} phone country.
     */
    public static Country getByCountryCode(String phone) {
        for (Country country : Country.values()) {
            if (phone.matches(country.getRegexCode())) {
                return country;
            }
        }
        return null;
    }
}
