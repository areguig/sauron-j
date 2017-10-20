package io.areguig.sauron.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("sauron")
public class SauronServerProperties {

    /**
     * Time interval in ms to update query component status
     */
    private long period = 30_000L;

    /**
     * Connect timeout when querying the component status.
     */
    private int connectTimeout = 2_000;

    /**
     * Read timeout when querying the component status
     */
    private int readTimeout = 5_000;

}
