package io.useraccount.api;

import io.useraccount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-05T13:15:18.047+01:00")

@Controller
public class UserApiController implements UserApi {
    @Autowired
    UserRepository userRepository;


}
