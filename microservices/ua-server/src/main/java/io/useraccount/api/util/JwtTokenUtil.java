package io.useraccount.api.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.useraccount.api.entities.UserEntity;
import io.useraccount.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
public class JwtTokenUtil implements Serializable {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserEntity userEntity) {

        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("email", userEntity.getEmail());
        builder.withClaim("isAdmin", userEntity.isAdmin());
        builder.withIssuedAt(new Date(System.currentTimeMillis()));
        builder.withExpiresAt(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000));
        String jwtToken = builder.sign(algorithm);

        return "Bearer " + jwtToken;
    }

    public Boolean validateToken(String token, UserDTO userDetail){
        final String userEmail = getUserEmailFromToken(token);
        return (userEmail.equals(userDetail.getEmail()) && ! isTokenExpired(token));
    }

    public String getUserEmailFromToken(String token) throws JWTVerificationException,NullPointerException{

        String[] jwt = token.split(" ");

        if (jwt[0].equals("Bearer") && jwt.length == 2){
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT tokenJWT = verifier.verify(jwt[1]);

            String email = tokenJWT.getClaim("email").asString();

            return email;
        }else{
            throw new JWTVerificationException("Not a bearer token");
        }
    }

    private Date getExpirationDateFromToken(String token) throws JWTVerificationException,NullPointerException{
        String[] jwt = token.split(" ");

        if (jwt[0].equals("Bearer") && jwt.length == 2){
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT tokenJWT = verifier.verify(jwt[1]);

            Date expired = tokenJWT.getExpiresAt();

            return expired;
        }else{
            throw new JWTVerificationException("Not a bearer token");
        }
    }
    public boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);

        return expiration.before(new Date());
    }
}
