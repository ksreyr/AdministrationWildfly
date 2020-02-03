package model;

import javax.persistence.*;

@Entity
@Table(name = "Helado")
public class Helado {
    @Id
    @GeneratedValue
    int heladoID;

    String name;

    int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    User user;

    public Helado(int heladoID, String name, int price) {
        this.name = name;
        this.price = price;
        this.heladoID = heladoID;
    }

    public Helado() {
    }

    public int getHeladoID() {
        return heladoID;
    }

    public void setHeladoID(int id) {
        this.heladoID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
