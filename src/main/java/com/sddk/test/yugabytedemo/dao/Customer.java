package com.sddk.test.yugabytedemo.dao;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

// @Entity
@Table("customer")
public class Customer {
  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY) // ?
  @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
  // public Long id;
  public UUID id = UUID.randomUUID();

  @Column
  public String name;
}
