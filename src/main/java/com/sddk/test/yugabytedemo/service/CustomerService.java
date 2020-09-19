package com.sddk.test.yugabytedemo.service;

import com.sddk.test.yugabytedemo.dao.Customer;
import com.sddk.test.yugabytedemo.dto.CustomerDto;
import com.sddk.test.yugabytedemo.repository.CustomerCassandraRepository;
import com.sddk.test.yugabytedemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  // @Autowired CustomerRepository customerRepository;
  @Autowired
  CustomerCassandraRepository customerRepository;
  public CustomerDto create( CustomerDto dto) {
    Customer customer = new Customer();
    customer.name = dto.name;
    customerRepository.save(customer);
    dto.id = customer.id;
    return dto;
  }
}
