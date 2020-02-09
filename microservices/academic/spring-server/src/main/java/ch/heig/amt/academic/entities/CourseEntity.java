package ch.heig.amt.academic.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Course")
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCourse")
    private Integer idCourse;

    @Column(name = "name")
    private String name;

    // -- Constructeur
    public CourseEntity() {}


    // -- Getter(s) et Setter(s)
    public Integer getIdCourse() {
        return idCourse;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

