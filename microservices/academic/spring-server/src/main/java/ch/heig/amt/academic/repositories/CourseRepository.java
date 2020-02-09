package ch.heig.amt.academic.repositories;

import ch.heig.amt.academic.entities.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Long> {
    Page<CourseEntity> findAll(Pageable pageable);
}
