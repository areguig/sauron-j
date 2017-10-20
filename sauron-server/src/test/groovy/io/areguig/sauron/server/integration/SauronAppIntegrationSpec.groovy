package io.areguig.sauron.server.integration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

/**
 * Created by akli on 16/01/2017.
 */
class SauronAppIntegrationSpec extends AbstractIntegrationSpec{

    @Autowired
    ApplicationContext context

    def "Spring context should start correctly."() {
        expect: "the spring context is not null and it contains the application bean "
        context != null
        context.containsBean("sauronApplication")

    }
}