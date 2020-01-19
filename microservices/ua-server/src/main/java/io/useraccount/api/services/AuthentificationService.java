package io.useraccount.api.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthenticationService {

    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }


    @Override
    public boolean checkPassword(String password, String encodedPassword) {
        try{
            return BCrypt.checkpw(password,encodedPassword);
        }catch (Exception e){
            return false;
        }
    }
}
