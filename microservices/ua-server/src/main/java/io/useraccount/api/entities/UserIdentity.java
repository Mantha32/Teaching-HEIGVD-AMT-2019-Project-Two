package io.useraccount.api.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

//lombok annotation
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

//jpa annotation
@Embeddable
public class UserIdentity implements Serializable {

    @NotNull @GeneratedValue
    private Long userId;

    @NotNull
    @Size(max = 250)
    private String email;

    public UserIdentity(@NotNull @Size(max = 250) String email){
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserIdentity that = (UserIdentity) o;

        if (!userId.equals(that.userId)) return false;

        return email.equals(that.email);
    }

}
