package io.areguig.sauron.server.integration

import io.areguig.sauron.server.SauronServerApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Created by akli on 20/04/2017.
 */
@ActiveProfiles("test")
@SpringBootTest(classes = SauronServerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AbstractIntegrationSpec extends Specification{
}
