package com.sddk.test.yugabytedemo.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceActionSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

  @Value("${cassandra.keyspace-name}")
  private String keyspaceName;

  @Value("${cassandra.local-datacenter}")
  private String datacenter;

  @Value("${cassandra.contact-points}")
  private String contactPoints;

  @Value("${cassandra.port}")
  private Integer port;

  @Override
  protected String getKeyspaceName() {
    return keyspaceName;
  }

  @Override
  protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    final CreateKeyspaceSpecification specification =
        CreateKeyspaceSpecification.createKeyspace(keyspaceName)
        .ifNotExists()
        .with(KeyspaceOption.DURABLE_WRITES, true)
        // .withSimpleReplication();
        .withNetworkReplication(DataCenterReplication.of(datacenter, 2));
    return List.of(specification);
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

  @Override
  protected String getLocalDataCenter() {
    return datacenter;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public String[] getEntityBasePackages() {
    return new String[] {"com.sddk.test.yugabytedemo.dao"};
  }
}
