package io.areguig.sauron.integration.ui

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Created by areguig on 06/02/2017.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("h2")
class IndexControllerSpec extends Specification {

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