package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TypeaheadResource {

    private final String TYPE_AHEAD_ENDPOINT = "/typeahead/{search}";
    private final String SUCESS_SCHEMA = "schemas/typeahead/typeahead_sucess.json";
    private final String BASE_URI= "https://www.expedia.com";
    private final String BASE_PATH = "/api/v4";


    public RequestSpecification doRequest(String search) {
        return  new RequestSpecBuilder()
        		.setBaseUri(BASE_URI)
        		.setBasePath(BASE_PATH)
				.addPathParam("search", search)
				.build();

    }


}
