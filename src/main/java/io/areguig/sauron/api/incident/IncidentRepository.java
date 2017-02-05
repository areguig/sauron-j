package io.areguig.sauron.api.incident;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by akli on 05/02/2017.
 */
@RepositoryRestResource(collectionResourceRel = "incident", path = "incident")
interface  IncidentRepository  extends CrudRepository<Incident, Long> {
}
