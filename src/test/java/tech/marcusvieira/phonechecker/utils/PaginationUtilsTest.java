package tech.marcusvieira.phonechecker.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;

public class PaginationUtilsTest {

    @Test
    void shouldBuildListWithPagination() {

        final List<Customer> customers = Arrays.asList(Customer.builder()
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

        final Page<Customer> customersWithPagination = PaginationUtils
            .buildListWithPagination(customers, PageRequest.of(0, 3));

        assertNotNull(customers);
        assertEquals(4, customersWithPagination.getTotalElements());
        assertEquals(2, customersWithPagination.getTotalPages());
        assertEquals(3, customersWithPagination.getSize());

        assertEntity(customers.get(0), customersWithPagination.toList().get(0));
        assertEntity(customers.get(1), customersWithPagination.toList().get(1));
        assertEntity(customers.get(2), customersWithPagination.toList().get(2));
    }

    @Test
    void shouldBuildPageNumbers() {

        final List<Customer> customers = Arrays.asList(Customer.builder()
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

        final Page<Customer> customersWithPagination = PaginationUtils
            .buildListWithPagination(customers, PageRequest.of(0, 3));

        final List<Integer> pageNumbers = PaginationUtils.buildPageNumbers(customersWithPagination);

        assertNotNull(pageNumbers);
        assertEquals(2, pageNumbers.size());
        assertEquals(1, pageNumbers.get(0));
        assertEquals(2, pageNumbers.get(1));
    }

    private void assertEntity(Customer expectedCustomer, Customer responseCustomer) {
        assertNotNull(responseCustomer.getId());
        assertEquals(expectedCustomer.getId(), responseCustomer.getId());
        assertEquals(expectedCustomer.getName(), responseCustomer.getName());
        assertEquals(expectedCustomer.getPhone(), responseCustomer.getPhone());
    }
}
