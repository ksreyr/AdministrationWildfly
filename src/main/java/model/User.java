package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User extends Owner {

    String password;

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Helado> helados;

    public User() {

    }

    public User(String name, String password, List<Helado> helados){
        this.name=name;
        this.password = password;
        this.helados=helados;
    }
}
