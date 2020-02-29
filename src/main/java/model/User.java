package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    int userID;

    String name;

    String password;

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Helado> helados;

    public User() {
    }


    public User(String name,String password,List<Helado> helados){
        this.name = name;
        this.password = password;
        this.helados=helados;
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
