package io.useraccount.api;


import io.useraccount.api.model.User;
import io.useraccount.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    void seeTheRoster(){
        for(User user : userRepository.findAll()){
            log.info(user.toString());
        }
    }
}
