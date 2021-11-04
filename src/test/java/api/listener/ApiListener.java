package api.listener;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ApiListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        //Relaxing HTTPS validation because of certs
        RestAssured.useRelaxedHTTPSValidation();

        //Filters to log the every request and response
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Override
    public void onFinish(ISuite suite) {
    }
}
