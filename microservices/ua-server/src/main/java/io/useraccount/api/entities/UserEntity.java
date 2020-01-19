package io.useraccount.api.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class UserEntity implements Serializable {


    @Id
    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    @Column
    @Size(max = 60)
    private String firstName;

    @NotNull
    @Column
    @Size(max = 60)
    private String lastName;

    @NotNull
    @Column
    @Size(max = 250)
    private String password;

    @NotNull
    @Column
    private boolean isAdmin;

    @NotNull
    @Column
    private boolean isBlocked;

    /* This private constructor, no argument is needed by JPA and hide it from public consumption */
    public UserEntity(){};

    public UserEntity(String email, String firstName, String lastName, String password, boolean isAdmin, boolean isBlocked){
        this();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isBlocked = isBlocked;
    }

    public void setIsAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString(){

        return email + " : " + firstName + " " + lastName + " is " + isAdmin;
    }
}
