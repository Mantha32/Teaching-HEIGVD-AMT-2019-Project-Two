package ch.heig.amt.academic.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "Salle")
public class SalleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalle")
    private Integer idSalle;

    @Column(name = "name")
    private String name;


    // -- Constructeur
    public SalleEntity() {}


    // -- Getter(s) et Setter(s)
    public Integer getIdCourse() {
        return idSalle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

