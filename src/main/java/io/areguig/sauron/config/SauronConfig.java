package io.areguig.sauron.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by akli on 04/02/2017.
 */
@Configuration
public class SauronConfig {

    @Value("${db.sauron}")
    private String profile;


    @Primary
    @Bean(name = "dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "db.sauron")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
