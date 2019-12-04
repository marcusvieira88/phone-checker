package tech.marcusvieira.phonechecker.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.entities.CustomerEntity;

public class CustomerMapperTest {

    @Test
    void shouldConvertEntityToDto() {
        final CustomerEntity customerEntity = CustomerEntity.builder()
            .id(1000L)
            .name("Marcus Test")
            .phone("(251) 911168450")
            .build();

        final Customer customerResponse = CustomerMapper.INSTANCE.entityToDto(customerEntity);

        assertEquals(customerEntity.getId(), customerResponse.getId());
        assertEquals(customerEntity.getName(), customerResponse.getName());
        assertEquals(customerEntity.getPhone(), customerResponse.getPhone());
    }
}
