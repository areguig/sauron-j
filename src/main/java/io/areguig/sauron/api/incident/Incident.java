package io.areguig.sauron.api.incident;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by akli on 05/02/2017.
 */
@Entity
@Data
public class Incident {

    @Id
    private long id;

    private long id_component;

    private int status;

    private String message;

    private Date created_at;

    private Date updated_at;
}
