package io.areguig.sauron.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.areguig.sauron.api.Component;
import io.areguig.sauron.domain.ComponentRepository;

/**
 * Created by akli on 05/02/2017.
 */
@Controller
public class IndexEndpoint {
    @Autowired
    private ComponentRepository componentRepository;

    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {

        List<Component> components = componentRepository.findAll();
        double systemsStatus = components.stream().mapToInt(value -> value.getStatus()).average().getAsDouble();
        model.put("systems_status", systemsStatus>1?2:systemsStatus<=0?0:1);
        model.put("components", components);
        model.put("time", new Date());
        model.put("incidents",null);
        return "index";
    }
}
