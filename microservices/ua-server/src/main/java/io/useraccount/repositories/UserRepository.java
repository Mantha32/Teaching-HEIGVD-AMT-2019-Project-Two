package io.useraccount.repositories;


import io.useraccount.api.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;



//import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
