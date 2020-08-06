package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public abstract class  Owner {
    @Id
    @GeneratedValue
    int ownerID;

    String name;

    public Owner(String name) {
        this.name=name;
    }

    public Owner() {
    }
}
