package ch.heig.amt.academic.api.stepsDefinition;

import ch.heig.amt.academic.ApiException;
import ch.heig.amt.academic.api.DefaultApi;
import ch.heig.amt.academic.api.dto.Course;
import ch.heig.amt.academic.api.dto.Enrollment;
import ch.heig.amt.academic.api.dto.Salle;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ch.heig.amt.academic.api.helpers.Environment;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class CreationEnrollmentSteps {

    private Environment environment;
    private DefaultApi api;

    public CreationEnrollmentSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Given("^there is an academic server$")
    public void there_is_a_Users_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have an enrollment payload$")
    public void i_have_a_user_payload() throws Throwable {
        Enrollment enrollment = new Enrollment();

        Salle salle = new Salle();
        salle.setIdSalle(1);
        salle.setName("H01");

        Course course = new Course();
        course.setIdCourse(2);
        course.setName("POO");

        enrollment.setCourse(course);
        enrollment.setSalle(salle);

        environment.setEnrollment(enrollment);
    }

    @When("^I POST it to the /enrollments endpoint with my admin token$")
    public void i_POST_it_to_the_enrollments_endpoint() throws Throwable {
        try {

            environment.setLastApiResponse(api.createEnrollmentWithHttpInfo(environment.getTokenAdmin(),environment.getEnrollment());
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

    @When("^I POST it to the /enrollments endpoint with my user token$")
    public void i_POST_it_to_the_enrollments_endpoint() throws Throwable {
        try {

            environment.setLastApiResponse(api.createEnrollmentWithHttpInfo(environment.getToken(),environment.getEnrollment());
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

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int code) throws Throwable {
        if (environment.lastApiCallThrewException()) {
            assertEquals(code, environment.getLastApiException());
        } else {
            assertEquals(code, environment.getLastStatusCode());
        }
    }

}
