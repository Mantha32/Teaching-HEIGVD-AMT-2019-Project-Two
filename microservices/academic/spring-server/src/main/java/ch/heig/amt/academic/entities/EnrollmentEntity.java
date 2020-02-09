package ch.heig.amt.academic.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Enrollment")
public class EnrollmentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnrollment")
    private Integer idTrip;

    @Column(name = "User_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "Salle_idSalle")
    private  SalleEntity salleEntity;

    @ManyToOne
    @JoinColumn(name = "Course_idCourse")
    private CourseEntity courseEntity;


}


