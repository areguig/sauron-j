package io.areguig.sauron.api.component;

import org.hibernate.validator.constraints.URL;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import io.areguig.sauron.api.incident.Incident;
import lombok.Getter;

/**
 * Created by akli on 04/02/2017.
 */
@Entity
@Getter
public class Component {

    @Id
    private long id;

    @NotNull
    private String name;

    private String description;

    @URL
    private String link;

    private int status;

    private Date created_at;

    private Date updated_at;

    private Date deleted_at;

    private boolean enabled;

    @OneToMany(mappedBy = "id_component")
    private List<Incident> incidents;

    public String getStatusStr(){
        return status==0?"Operational":status==1?"Partial outage":"Major outage";
    }
}
