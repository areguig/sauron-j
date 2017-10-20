package io.areguig.sauron.server.to;

import org.hibernate.validator.constraints.URL;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by akli on 04/02/2017.
 */
@Data
public class Component {

    private Integer id;

    @NotNull
    private String name;

    private String description;

    @URL
    private String link;

    public int status;

    private Date created_at;

    private Date updated_at;

    private Date deleted_at;

    private boolean enabled;

    public String getStatusStr(){
        return status==0?"Operational":status==1?"Partial outage":"Major outage";
    }
}
