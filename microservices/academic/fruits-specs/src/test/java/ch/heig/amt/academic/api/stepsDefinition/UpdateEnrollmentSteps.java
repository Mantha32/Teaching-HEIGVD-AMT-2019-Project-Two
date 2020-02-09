package ch.heig.amt.academic.api.stepsDefinition;

import ch.heig.amt.academic.ApiException;
import ch.heig.amt.academic.api.DefaultApi;
import cucumber.api.java.en.When;
import ch.heig.amt.academic.api.helpers.Environment;


/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class UpdateEnrollmentSteps {

    private Environment environment;
    private DefaultApi api;

    public UpdateEnrollmentSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @When("^I PATCH it to the /trips/(\\d+) endpoint$")
    public void i_POST_it_to_the_users_endpoint(Integer idEnrollment) throws Throwable {
        try {
            environment.setLastApiResponse(api.updateEnrollmentWithHttpInfo(environment.getToken(),idEnrollment,environment.getEnrollment()));
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
