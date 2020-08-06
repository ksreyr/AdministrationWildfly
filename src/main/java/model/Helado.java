package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "Helado.findHeladoByUserName", query = "SELECT h FROM Helado h WHERE h.owner = :name")
})
public class Helado {
    @Id
    @GeneratedValue
    int heladoID;

    String name;

    int price;

    int number;

    String owner;
    //CONSTRUCTOR
    public Helado(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Helado() {
    }

    public Helado(String name, int price, int number,String owner) {
        this.name=name;
        this.price=price;
        this.number=number;
        this.owner=owner;

    }
}
