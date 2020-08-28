package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public abstract class  Owner {
    @Id
    @GeneratedValue
    int ownerID;

    String name;

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    List<Helado> helados;

    public Owner(String name) {
        this.name=name;
    }

    public Owner() {
    }
}
