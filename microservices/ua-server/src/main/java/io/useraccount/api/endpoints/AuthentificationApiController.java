package io.useraccount.api.endpoints;

import io.useraccount.api.AuthenticateApi;
import io.useraccount.api.entities.UserEntity;
import io.useraccount.api.model.AuthDTO;
import io.useraccount.api.services.AuthentificationService;
import io.useraccount.api.util.JwtTokenUtil;
import io.useraccount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
public class AuthentificationApiController implements AuthenticateApi {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthentificationService authentificationService;

    @Autowired
    JwtTokenUtil  jwtTokenUtil;
    @Override
    public ResponseEntity<String> loginUser(@Valid AuthDTO authDTO) {
        try {

            UserEntity userEntity = userRepository.findById(authDTO.getEmail()).get();
            if(authentificationService.checkPassword(authDTO.getPassword(), userEntity.getPassword())){
                String generatedToken = jwtTokenUtil.generateToken(userEntity);

                return ResponseEntity.ok(generatedToken);
            }else {
            // unauthorized status (401)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }catch (Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    }
}
