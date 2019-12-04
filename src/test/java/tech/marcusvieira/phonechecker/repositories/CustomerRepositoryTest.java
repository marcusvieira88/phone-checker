package tech.marcusvieira.phonechecker.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.marcusvieira.phonechecker.entities.CustomerEntity;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void shouldFindAllCustomers() {

        final Optional<CustomerEntity> customer1 = customerRepository.findById(1L);
        final Optional<CustomerEntity> customer2 = customerRepository.findById(2L);

        final List<CustomerEntity> customers = customerRepository.findAll();

        assertEquals(41, customers.size());
        assertEntity(customer1.get(), customers.get(1));
        assertEntity(customer2.get(), customers.get(2));
    }

    private void assertEntity(CustomerEntity customerEntity, CustomerEntity savedEntity) {
        assertNotNull(savedEntity.getId());
        assertEquals(customerEntity.getId(), savedEntity.getId());
        assertEquals(customerEntity.getName(), savedEntity.getName());
        assertEquals(customerEntity.getPhone(), savedEntity.getPhone());
    }
}
