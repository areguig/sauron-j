package io.areguig.sauron.server.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
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
public class SauronServerCoreConfiguration {

    @Primary
    @Bean(name = "dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "db.sauron")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DSLContext getWriteDSLContext() {
        Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);
        return new DefaultDSLContext(new DefaultConfiguration().derive(SQLDialect.POSTGRES)
                .derive(getDataSource()).derive(settings));
    }
}
