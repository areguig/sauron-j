package io.areguig.sauron.server.ui;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.areguig.sauron.server.domain.ComponentRepository;
import io.areguig.sauron.server.to.Component;

/**
 * Created by akli on 05/02/2017.
 */
@Controller
public class IndexEndpoint {
    @Autowired
    private DSLContext dslContext;

    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {

        List<Component> components = ComponentRepository.findAll().apply( dslContext);
        double systemsStatus = components.stream().mapToInt(c -> c.status).average().orElse(0);
        model.put("systems_status", systemsStatus>1?2:systemsStatus<=0?0:1);
        model.put("components", components);
        model.put("time", new Date());
        model.put("incidents",null);
        return "index";
    }
}
