package io.areguig.sauron.server.integration.api.component

import io.areguig.sauron.server.integration.AbstractIntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by areguig on 06/02/2017.
 */

class ComponentEndpointSpec extends AbstractIntegrationSpec {

    @Autowired
    TestRestTemplate restTemplate

    def 'api/component returns OK and a JSON list'() {
        when: 'GET /api/component'
        ResponseEntity response = restTemplate.getForEntity('/api/component', String.class)
        then: 'status is OK and content is a json array'
        response.statusCode == HttpStatus.OK
        response.getHeaders().get('Content-Type').get(0) == 'application/json;charset=UTF-8'
        !response.body.isEmpty()
        response.body.startsWith("[")
        response.body.endsWith("]")
    }

    def 'Get api/component returns a component after Post /api/component'(){
        given: ''
        when: ''
       // ResponseEntity respPost = restTemplate.postForEntity("/api/component",)
        ResponseEntity response = restTemplate.getForEntity('/api/component', String.class)
        then: ''
        response.statusCode == HttpStatus.OK
    }

}