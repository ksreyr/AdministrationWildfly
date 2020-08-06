package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Punto extends Owner{

    public Punto(String name) {
        this.name=name;
    }

    public Punto() {
    }
}
