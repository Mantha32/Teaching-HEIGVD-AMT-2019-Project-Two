package ch.heig.amt.academic.api.stepsDefinition;

import ch.heig.amt.academic.ApiException;
import ch.heig.amt.academic.api.DefaultApi;
import ch.heig.amt.academic.api.helpers.Environment;
import cucumber.api.java.en.When;


/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class GetEnrollmentsSteps {

    private Environment environment;
    private DefaultApi api;

    public GetEnrollmentsSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @When("^I GET a list of enrollment to the /enrollments endpoint with offset (\\d+) and limit (\\d+)$")
    public void i_get_it_to_the_enrollment_endpoint(Integer offset, Integer limit) throws Throwable {
        try {

            environment.setLastApiResponse(api.getEnrollementsWithHttpInfo(environment.getToken(),offset,limit)
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

    @When("^I GET a list of all enrollment to the /enrollments endpoint with offset (\\d+) and limit (\\d+)$")
    public void i_get_it_to_the_enrollment_endpoint(Integer offset, Integer limit) throws Throwable {
        try {

            environment.setLastApiResponse(api.getEnrollementsWithHttpInfo(environment.getTokenAdmin(),offset,limit)
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

}
