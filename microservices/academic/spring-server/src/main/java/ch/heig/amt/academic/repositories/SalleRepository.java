package ch.heig.amt.academic.repositories;

import ch.heig.amt.academic.entities.CourseEntity;
import ch.heig.amt.academic.entities.SalleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SalleRepository extends CrudRepository<SalleEntity, Long>{
    Page<SalleEntity> findAll(Pageable pageable);
}
