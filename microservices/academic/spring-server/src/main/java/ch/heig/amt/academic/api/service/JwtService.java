package ch.heig.amt.academic.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;


@Service
public class JwtService  {
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    @Value("${jwt.secret}")
    private String JWT_SECRET;


    public boolean validateToken(String token) throws AccessDeniedException,NullPointerException{
        String headerToken = "Bearer ";

        if(token.startsWith(headerToken)){
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT decodedJWT = verifier.verify(token.substring(headerToken.length()));
            return true;
        }else{
            throw new AccessDeniedException("Authorization must be Bearer");
        }

    }

    public UserAuthority getUserAuthority(String token){
        String headerToken = "Bearer ";
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .build(); //Reusable verifier instance

        String mail =  JWT.decode(token.substring(headerToken.length())).getClaim("email").asString;
        boolean isAdmin = JWT.decode(token.substring(headerToken.length())).getClaim("isAdmin").asBoolean;

        return new UserAuthority(mail,isAdmin);

    }

}
