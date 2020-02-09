package ch.heig.amt.academic.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "User")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "email")
    private String email;

    // -- Constructeur
    public UserEntity() {}

    public UserEntity(String email) {this.email = email;}


    // -- Getter(s) et Setter(s)
    public String getEmail() {
        return email;
    }

    public String getName() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
