package ch.heig.amt.academic.api.endpoints;

import ch.heig.amt.academic.api.SallesApi;
import ch.heig.amt.academic.api.model.SalleDTO;
import ch.heig.amt.academic.api.service.UserAuthority;
import ch.heig.amt.academic.entities.SalleEntity;
import ch.heig.amt.academic.repositories.SalleRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

public class SalleApiController implements SallesApi {
    @Autowired
    HttpServletRequest request;

    @Autowired
    SalleRepository salleRepository;

    @Override
   public ResponseEntity<List<SalleDTO>> getSalles(@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value = "offset",
            required = false, defaultValue="0") Integer offset, @ApiParam(value = "", defaultValue = "10")
            @Valid @RequestParam(value = "limit", required = false, defaultValue="10") Integer limit){
        try{

            UserAuthority userAuthority = (UserAuthority)(request.getAttribute("userAuthority"));

            if(userAuthority.isAdmin()){
                List<SalleDTO> salles = salleRepository.findAll(PageRequest.of(offset,limit)).map(this::toSalleDTO).toList();

                return new ResponseEntity(salles, HttpStatus.OK);
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

    private SalleDTO toSalleDTO(SalleEntity salleEntity){
        SalleDTO salleDTO = new SalleDTO();
        salleDTO.setIdSalle(salleEntity.getIdCourse().intValue());
        salleDTO.setName(salleEntity.getName());

        return salleDTO;
    }

}
