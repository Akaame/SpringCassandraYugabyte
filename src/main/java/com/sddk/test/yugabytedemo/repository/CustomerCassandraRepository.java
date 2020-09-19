package com.sddk.test.yugabytedemo.repository;

import com.sddk.test.yugabytedemo.dao.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CustomerCassandraRepository
    extends CassandraRepository<Customer, Long> {
}
