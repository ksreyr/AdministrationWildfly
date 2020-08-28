package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Punto extends Owner{



    public Punto(String name) {
        this.name=name;
    }

    public Punto() {

    }
}
