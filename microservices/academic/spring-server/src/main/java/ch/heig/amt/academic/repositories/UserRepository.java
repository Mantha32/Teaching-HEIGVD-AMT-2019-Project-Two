package ch.heig.amt.academic.repositories;

import ch.heig.amt.academic.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Olivier Liechti on 26/07/17.
 */
public interface UserRepository extends CrudRepository<UserEntity, String>{

}
