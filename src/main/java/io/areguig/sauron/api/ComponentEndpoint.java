package io.areguig.sauron.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.areguig.sauron.domain.ComponentRepository;

/**
 * Created by akli on 26/02/2017.
 */
@RestController
@RequestMapping("/api/component")
public class ComponentEndpoint {

    @Autowired
    private ComponentRepository componentRepository;

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Component>> getComponents(){
        return new ResponseEntity<>(componentRepository.findAll(),null, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Component> getComponentById(@PathVariable Integer id){
        Component result =null;
        if(id>0){
            result=  componentRepository.findById(id);
        }
        return new ResponseEntity<>(result,null, result !=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
