package io.areguig.sauron.integration

import io.areguig.sauron.SauronApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Created by akli on 20/04/2017.
 */
@ActiveProfiles("test")
@SpringBootTest(classes = SauronApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AbstractIntegrationSpec extends Specification{
}
