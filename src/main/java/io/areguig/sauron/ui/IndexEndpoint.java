package io.areguig.sauron.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import io.areguig.sauron.api.component.Component;
import io.areguig.sauron.api.component.ComponentRepository;

/**
 * Created by akli on 05/02/2017.
 */
@Controller
public class IndexEndpoint {
    @Autowired
    private ComponentRepository componentRepository;

    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {

        List<Component> components = StreamSupport.stream(componentRepository.findAll()
                .spliterator(), false).collect(Collectors.toList());
        model.put("status", components.stream().mapToInt(value -> value.getStatus()).sum());
        model.put("components", components);
        model.put("time", new Date());
        return "index";
    }
}
