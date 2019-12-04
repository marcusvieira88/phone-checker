package tech.marcusvieira.phonechecker.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.entities.CustomerEntity;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer entityToDto(CustomerEntity customerEntity);
}
