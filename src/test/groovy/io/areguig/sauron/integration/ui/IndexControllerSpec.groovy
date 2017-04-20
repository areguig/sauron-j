package io.areguig.sauron.integration.ui

import io.areguig.sauron.integration.AbstractIntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by areguig on 06/02/2017.
 */
class IndexControllerSpec extends AbstractIntegrationSpec {

    @Autowired
    TestRestTemplate restTemplate


    void "should return 200 OK and a body "() {
        when:
        ResponseEntity entity = restTemplate.getForEntity('/', String.class)
        then:
        entity.statusCode == HttpStatus.OK
        entity.body.contains("<body>")
    }

}