package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User {


    @Id
    @GeneratedValue
    int userID;
    String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Helado> helados;

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) {
        this.userID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Helado> getHelados() {
        return helados;
    }

    public void setHelados(List<Helado> helados) {
        this.helados = helados;
    }
}
