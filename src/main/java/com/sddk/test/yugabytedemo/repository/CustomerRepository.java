package com.sddk.test.yugabytedemo.repository;

import com.sddk.test.yugabytedemo.dao.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
