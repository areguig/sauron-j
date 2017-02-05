package io.areguig.sauron.api.component;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by akli on 04/02/2017.
 */
@RepositoryRestResource(collectionResourceRel = "component", path = "component")
public interface ComponentRepository extends CrudRepository<Component, Long>
{
    List<Component> findByName(@Param("name") String name);
}
