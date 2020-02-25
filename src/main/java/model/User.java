package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    int userID;

    String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Helado> helados;

    public User() {
    }

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", helados=" + helados +
                '}';
    }
}
