package io.areguig.sauron.domain;

import org.jooq.DSLContext;
import org.jooq.Record9;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

import io.areguig.sauron.api.Component;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;
import static org.jooq.impl.SQLDataType.BOOLEAN;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.TIMESTAMP;
import static org.jooq.impl.SQLDataType.VARCHAR;

/**
 * Created by akli on 04/02/2017.
 */

@Repository
public class ComponentRepository {

    @Autowired
    private DSLContext dsl;


    public List<Component> findAll(){
        return getComponentSelect()
                .orderBy(field("updated_at",TIMESTAMP).desc())
                .fetchInto(Component.class);
    }
    public Component findById(Integer id){
        return getComponentSelect()
                .where(field("id",INTEGER).eq(id))
                .fetchOneInto(Component.class);
    }

    /**
     * PRIVATE STUFF.
     * */


    private SelectJoinStep<Record9<Integer, String, String, String, Integer, Timestamp, Timestamp, Timestamp, Boolean>> getComponentSelect() {
        return dsl.select(
                field("id", INTEGER),
                field("name", VARCHAR),
                field("description", VARCHAR),
                field("link",VARCHAR),
                field("status",INTEGER),
                field("created_at",TIMESTAMP),
                field("updated_at",TIMESTAMP),
                field("deleted_at",TIMESTAMP),
                field("enabled",BOOLEAN)
        ).from(table("component")
        );
    }


}
