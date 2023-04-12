package com.spring.app.springapp3.mapper;

import com.spring.app.springapp3.entity.Customer;
import com.spring.app.springapp3.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
