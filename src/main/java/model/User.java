package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User extends Owner {

    String password;

    public User() {

    }

    public User(String name, String password, List<Helado> helados){
        this.name = name;
        this.password = password;
        this.helados=helados;
    }
}
