package io.useraccount.api.util;

import io.useraccount.api.entities.UserEntity;
import io.useraccount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DatabaseLoader {
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void initDatabase(){

        UserEntity dupont = new UserEntity("alex.dupont@amt.org", "Alex", "Dupont", "dupontdupont");
        dupont.setIsAdmin(false);
        userRepository.save(dupont);

        UserEntity john = new UserEntity("john.do@amt.org", "John", "Do", "johnjohn");
        john.setIsAdmin(true);
        userRepository.save(john);

    }
}
