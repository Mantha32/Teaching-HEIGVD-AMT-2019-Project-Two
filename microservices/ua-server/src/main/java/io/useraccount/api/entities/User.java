package io.useraccount.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//lombok annotation
@ToString
@Getter
@Setter

//jpa annotation
@Entity
@Table(name = "users")
public class User {

    @EmbeddedId
    private UserIdentity userIdentity;

    @NotNull
    @Size(max = 60)
    private String firstName;

    @NotNull
    @Size(max = 60)
    private String lastName;

    @NotNull
    @Size(max = 250)
    private String password;

    @OneToMany(mappedBy="User")
    private List<Role> roles;

    /* This private constructor, no argument is needed by JPA and hie it form public consumption */
    private User(){};

    public User(UserIdentity userIdentity, String firstName, String lastName, String password){
        this();
        this.userIdentity = userIdentity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

}
