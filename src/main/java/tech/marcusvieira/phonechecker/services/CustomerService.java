package tech.marcusvieira.phonechecker.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;

public interface CustomerService {

    Page<Customer> getCustomers(Country country, PhoneStatus status, Pageable pageable);
}
