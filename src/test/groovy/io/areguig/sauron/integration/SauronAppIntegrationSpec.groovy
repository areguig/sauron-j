package io.areguig.sauron.integration

import io.areguig.sauron.SauronApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Created by akli on 16/01/2017.
 */

@SpringBootTest(classes = SauronApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("h2")
class SauronAppIntegrationSpec extends Specification{

    @Autowired
    ApplicationContext context

    def "should boot up without errors"() {
        expect:
        context != null
        context.containsBean("sauronApplication")
    }
}