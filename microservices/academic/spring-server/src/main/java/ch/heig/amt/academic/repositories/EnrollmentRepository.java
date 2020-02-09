package ch.heig.amt.academic.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ch.heig.amt.academic.entities.EnrollmentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnrollmentRepository extends PagingAndSortingRepository<EnrollmentEntity, Long> {
    Page<EnrollmentEntity> findAllByEmail(String userMail, Pageable pageable);
    boolean existsByEmail(String userEmail);
}
