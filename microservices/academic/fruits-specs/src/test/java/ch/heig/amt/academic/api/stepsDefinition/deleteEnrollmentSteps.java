package ch.heig.amt.academic.api.stepsDefinition;

import ch.heig.amt.academic.ApiException;
import ch.heig.amt.academic.api.DefaultApi;
import ch.heig.amt.academic.api.dto.EnrollmentDTO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import ch.heig.amt.academic.api.helpers.Environment;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class deleteEnrollmentSteps {

    private Environment environment;
    private DefaultApi api;

    Integer idEnrollment;
    public deleteEnrollmentSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @When("^I DELETE it to the /enrollments/idEnrollment endpoint with my admin token$")
    public void i_delete_it_to_the_users_admin_endpoint() {
        try {
            EnrollmentDTO enrollmentDTO = (EnrollmentDTO) environment.getLastApiResponse().getData();
            idEnrollment= enrollmentDTO.getIdEnrollement();

            environment.setLastApiResponse(api.deleteEnrollmentWithHttpInfo(environment.getTokenAdmin(),idEnrollment));
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }

    @When("^I DELETE it to the /enrollments/idEnrollment endpoint with my user token$")
    public void i_delete_it_to_the_users_endpoint() {
        try {
            EnrollmentDTO enrollmentDTO = (EnrollmentDTO) environment.getLastApiResponse().getData();
            idEnrollment= enrollmentDTO.getIdEnrollement();

            environment.setLastApiResponse(api.deleteEnrollmentWithHttpInfo(environment.getToken(),idEnrollment));
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }

    @And("^I deleted successfully an enrollment$")
    public void i_deleted_sucessfully_an_enrollment() {
        try {
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }
}
