package io.areguig.sauron.api;

import java.util.Date;

import lombok.Data;

/**
 * Created by akli on 05/02/2017.
 */
@Data
public class Incident {


    private long id;

    private long id_component;

    private int status;

    private String message;

    private Date created_at;

    private Date updated_at;
}
