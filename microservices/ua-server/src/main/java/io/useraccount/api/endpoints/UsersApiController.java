package io.useraccount.api.endpoints;

import io.swagger.annotations.ApiParam;
import io.useraccount.api.UsersApi;
import io.useraccount.api.entities.UserEntity;
import io.useraccount.api.model.User;
import io.useraccount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-05T13:15:18.047+01:00")

@Controller
public class UsersApiController implements UsersApi {
    @Autowired
    UserRepository userRepository;

     public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object based on the User definition" ,required=true )  @Valid @RequestBody User body) {


         return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    private UserEntity toUserEntity(User user){
         UserEntity entity = new UserEntity();

        entity.setEmail(user.getEmail());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setPassword("default password");
        entity.setIsAdmin(user.getIsAdmin());

         return entity;

    }

    private User toUser(UserEntity userEntity){
         User user = new User();
         return  user;
    }   
}
