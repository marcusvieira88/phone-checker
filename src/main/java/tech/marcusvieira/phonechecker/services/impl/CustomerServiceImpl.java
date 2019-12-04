package tech.marcusvieira.phonechecker.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;
import tech.marcusvieira.phonechecker.mappers.CustomerMapper;
import tech.marcusvieira.phonechecker.repositories.CustomerRepository;
import tech.marcusvieira.phonechecker.services.CustomerService;
import tech.marcusvieira.phonechecker.utils.PaginationUtils;
import tech.marcusvieira.phonechecker.validators.PhoneValidator;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Returns customers list based on country, status and current pagination state.
     *
     * @param country  - customer country.
     * @param status   - phone status.
     * @param pageable - current pagination state.
     * @return {@link Page<Customer>} list of customers with pagination.
     */
    public Page<Customer> getCustomers(Country country, PhoneStatus status, Pageable pageable) {

        final List<Customer> customers = Optional.ofNullable(customerRepository.findAll())
            .map(entities -> entities.stream()
                .map(CustomerMapper.INSTANCE::entityToDto)
                .peek(CustomerServiceImpl::populateCountryAndPhoneStatus)
                .filter(c -> country == null || c.getCountry() == country)
                .filter(c -> status == null || c.getPhoneStatus() == status)
                .collect(Collectors.toList()))
            .orElse(Collections.emptyList());

        return PaginationUtils.buildListWithPagination(customers, pageable);
    }

    private static void populateCountryAndPhoneStatus(Customer customer) {
        customer.setCountry(Country.getByCountryCode(customer.getPhone()));
        customer.setPhoneStatus(PhoneValidator.isValid(customer.getCountry(), customer.getPhone()));
    }
}