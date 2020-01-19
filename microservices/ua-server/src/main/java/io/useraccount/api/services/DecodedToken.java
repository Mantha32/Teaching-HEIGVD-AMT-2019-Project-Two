package io.useraccount.api.services;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class DecodedToken {
    String email;
    Boolean isAdmin;
}
