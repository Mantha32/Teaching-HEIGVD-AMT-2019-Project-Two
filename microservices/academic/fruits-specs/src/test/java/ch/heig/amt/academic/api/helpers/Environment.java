package ch.heig.amt.academic.api.helpers;

import ch.heig.amt.academic.ApiException;
import ch.heig.amt.academic.ApiResponse;
import ch.heig.amt.academic.api.DefaultApi;
import ch.heig.amt.academic.api.dto.Course;
import ch.heig.amt.academic.api.dto.Enrollment;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Olivier Liechti on 24/06/17.
 */
public class Environment {

    private DefaultApi api = new DefaultApi();

    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;

    Enrollment enrollment;
    String tokenAdmin;
    String tokenUser;
    Course course;

    public Environment() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
        String url = properties.getProperty("ch.heig.amt.academic.server.url");
        api.getApiClient().setBasePath(url);

    }

    public DefaultApi getApi() {
        return api;
    }

    public ApiResponse getLastApiResponse() {
        return lastApiResponse;
    }

    public void setLastApiResponse(ApiResponse lastApiResponse) {
        this.lastApiResponse = lastApiResponse;
    }

    public ApiException getLastApiException() {
        return lastApiException;
    }

    public void setLastApiException(ApiException lastApiException) {
        this.lastApiException = lastApiException;
    }

    public boolean lastApiCallThrewException(){
        return lastApiCallThrewException;
    }

    public void setLastApiCallThrewException(boolean lastApiCallThrewException) {
        this.lastApiCallThrewException = lastApiCallThrewException;
    }

    public int getLastStatusCode() {
        return lastStatusCode;
    }

    public void setLastStatusCode(int lastStatusCode) {
        this.lastStatusCode = lastStatusCode;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public  void setCourse(Course course){this.course = course;}

    public Course getCourse(){return  course;}

    public void setToken(String token) {
        this.tokenUser = token;
    }

    public String getToken() {
        return tokenUser;
    }

    public void setTokenAdmin(String token) {
        this.tokenAdmin = token;
    }

    public String getTokenAdmin() {
        return tokenAdmin;
    }
}
