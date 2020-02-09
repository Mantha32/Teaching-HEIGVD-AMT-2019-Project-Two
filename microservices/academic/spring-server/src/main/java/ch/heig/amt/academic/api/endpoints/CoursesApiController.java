package ch.heig.amt.academic.api.endpoints;

import ch.heig.amt.academic.api.CoursesApi;
import ch.heig.amt.academic.api.model.Course;
import ch.heig.amt.academic.api.model.CourseDTO;
import ch.heig.amt.academic.api.service.UserAuthority;
import ch.heig.amt.academic.entities.CourseEntity;
import ch.heig.amt.academic.repositories.CourseRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

public class CoursesApiController implements CoursesApi {

    private static final Logger log = LoggerFactory.getLogger(CoursesApiController.class);

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    HttpServletRequest request;

    @Override
    public ResponseEntity<List<CourseDTO>> getCourses(@ApiParam(value = "", defaultValue = "0")
                                                          @Valid @RequestParam(value = "offset", required = false, defaultValue="0") Integer offset,
                                                      @ApiParam(value = "", defaultValue = "10") @Valid @RequestParam(value = "limit", required = false, defaultValue="10") Integer limit)
     {
         try{

             UserAuthority userAuthority = (UserAuthority)(request.getAttribute("userAuthority"));

             if(userAuthority.isAdmin()){
                 List<CourseDTO> courses = courseRepository.findAll(PageRequest.of(offset,limit)).map(this::toCourseDTO).toList();

                 return new ResponseEntity(courses, HttpStatus.OK);
             }else{
                 new ResponseEntity<>(HttpStatus.FORBIDDEN);
             }

         }catch (IllegalArgumentException ex) {
             //400
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         } catch (Exception ex) {
             //403
             return new ResponseEntity<>(HttpStatus.FORBIDDEN);
         }

    }

    @Override
    public ResponseEntity<CourseDTO> createCourse(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Course course){
        try{

            UserAuthority userAuthority = (UserAuthority)(request.getAttribute("userAuthority"));

            if(userAuthority.isAdmin()){
                List<CourseDTO> courses = (List<CourseDTO>) courseRepository.save(toCourseEntity(course));

                return new ResponseEntity(courses, HttpStatus.OK);
            }else{
                new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }catch (IllegalArgumentException ex) {
            //400
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            //403
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    private CourseDTO toCourseDTO(CourseEntity courseEntity){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setIdCourse(courseEntity.getIdCourse().intValue());
        courseDTO.setName(courseEntity.getName());

        return courseDTO;
    }

    private CourseEntity toCourseEntity(Course  course){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(course.getName());

        return courseEntity;
    }

}
