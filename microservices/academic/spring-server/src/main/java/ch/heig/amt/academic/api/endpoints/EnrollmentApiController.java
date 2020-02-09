package ch.heig.amt.academic.api.endpoints;

import ch.heig.amt.academic.api.EnrollementsApi;
import ch.heig.amt.academic.api.model.Enrollment;
import ch.heig.amt.academic.api.model.EnrollmentDTO;
import ch.heig.amt.academic.api.service.UserAuthority;
import ch.heig.amt.academic.entities.EnrollmentEntity;
import ch.heig.amt.academic.entities.UserEntity;
import ch.heig.amt.academic.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public class EnrollmentApiController implements EnrollementsApi {

    @Autowired
    UserAuthority userAuthority;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpServletRequest request;

    @Override
    public ResponseEntity<EnrollmentDTO> createEnrollment(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                          @ApiParam(value = "" ,required=true )  @Valid @RequestBody Enrollment enrollment) {
        UserAuthority userAuthority = (UserAuthority) request.getAttribute("userAuthority");

        EnrollmentEntity enrollmentEntity = toEnrollmentEntity(enrollment);

        return ResponseEntity.status(HttpStatus.CREATED).body(EnrollmentDTO);
    }


        private void addUserIfNotExist(String email){
        if(!userRepository.existsById(email)){
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(email);
            userRepository.save(userEntity);
        }
    }
    private EnrollmentEntity toEnrollmentEntity(Enrollment enrollment){
        EnrollmentEntity enrollmentEntity = new EnrollmentEntity();

        return  enrollmentEntity;
    }
}
