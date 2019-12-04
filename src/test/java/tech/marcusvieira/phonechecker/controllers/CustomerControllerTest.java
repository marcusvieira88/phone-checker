package tech.marcusvieira.phonechecker.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.support.BindingAwareModelMap;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;
import tech.marcusvieira.phonechecker.services.CustomerService;

@SpringBootTest
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void shouldReturnAllCustomers() {

        final List<Customer> customersMock = Arrays.asList(Customer.builder()
                .id(1L)
                .name("Nelson Nelson")
                .phone("(251) 911168450")
                .country(Country.ETHIOPIA)
                .phoneStatus(PhoneStatus.INVALID)
                .build(),
            Customer.builder()
                .id(2L)
                .name("Tanvi Sachdeva")
                .phone("(258) 849181828")
                .country(Country.MOZAMBIQUE)
                .phoneStatus(PhoneStatus.INVALID)
                .build(),
            Customer.builder()
                .id(3L)
                .name("Yonatan Tekelay")
                .phone("(251) 911168450")
                .country(Country.ETHIOPIA)
                .phoneStatus(PhoneStatus.INVALID)
                .build(),
            Customer.builder()
                .id(4L)
                .name("Fanetahune Abaia")
                .phone("(212) 691933626")
                .country(Country.MOROCCO)
                .phoneStatus(PhoneStatus.VALID)
                .build());

        when(customerService.getCustomers(null, null, PageRequest.of(0, 10)))
            .thenReturn(new PageImpl<>(customersMock, PageRequest.of(0, 10), customersMock.size()));

        final String page = customerController.getCustomers(new BindingAwareModelMap(), null, null, null, null);

        assertEquals("home", page);
    }
}
