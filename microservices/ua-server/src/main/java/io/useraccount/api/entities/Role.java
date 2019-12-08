/*
*  source for composite key: https://www.callicoder.com/hibernate-spring-boot-jpa-composite-primary-key-example/
* */

package io.useraccount.api.entities;

import lombok.*;


import javax.persistence.*;

//lombok annotation
@ToString
@Getter
@Setter

//jpa annotation
@Entity
@Table(name = "roles")
public class Role {
    @Id @GeneratedValue
    private Long id;
    private String authority;

    @ManyToOne
    private User user;


    /* This private constructor, no argument is needed by JPA and hie it form public consumption */
    private Role(){}

    public Role(String role){
        this();
        this.authority = role;
    }
}
