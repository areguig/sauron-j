package io.areguig.sauron.server.domain;

import org.jooq.DSLContext;
import org.jooq.Record9;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

import io.areguig.sauron.server.to.Component;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;
import static org.jooq.impl.SQLDataType.BOOLEAN;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.TIMESTAMP;
import static org.jooq.impl.SQLDataType.VARCHAR;

/**
 * Created by akli on 04/02/2017.
 */


public class ComponentRepository {

    public static Function<DSLContext,List<Component>> findAll(){
        return  dsl -> getComponentSelect().apply(dsl)
                .orderBy(field("updated_at",TIMESTAMP).desc())
                .fetchInto(Component.class);
    }

    public static Function<DSLContext,Component> findById(Integer id){
        return dsl-> getComponentSelect().apply(dsl).where(field("id",INTEGER).eq(id))
                .fetchOneInto(Component.class);
    };

    /**
     * PRIVATE STUFF.
     * */


    private static Function<DSLContext,SelectJoinStep<Record9<Integer, String, String, String, Integer, Timestamp, Timestamp, Timestamp, Boolean>>> getComponentSelect() {
        return dsl ->dsl.select(
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
