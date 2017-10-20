package io.areguig.sauron.server.domain;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by akli on 05/02/2017.
 */

@Repository
class  IncidentRepository  {

    @Autowired
    private DSLContext dsl;

}
