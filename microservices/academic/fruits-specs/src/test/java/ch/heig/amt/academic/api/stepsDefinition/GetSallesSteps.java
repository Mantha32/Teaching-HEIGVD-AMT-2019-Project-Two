package ch.heig.amt.academic.api.stepsDefinition;

import ch.heig.amt.academic.ApiException;
import ch.heig.amt.academic.api.DefaultApi;
import cucumber.api.java.en.When;

import ch.heig.amt.academic.api.helpers.Environment;


/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class GetSallesSteps {

    private Environment environment;
    private DefaultApi api;

    public GetSallesSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @When("^I GET a list of all available salle to the /salles endpoint$")
    public void i_GET_it_to_the_salle_endpoint() throws Throwable {
        try {
            environment.setLastApiResponse(api.getSallesWithHttpInfo());
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
