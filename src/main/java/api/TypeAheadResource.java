package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TypeAheadResource {

    private final String TYPE_AHEAD_ENDPOINT = "/typeahead/{search}";
    private final String SUCESS_SCHEMA = "schemas/typeahead/typeahead_sucess.json";

    public TypeAheadResource() {
        RestAssured.baseURI = "https://www.expedia.com";
        RestAssured.basePath = "/api/v4";
    }

    public Response doRequest(String search) {
        return  RestAssured
                .given()
                .pathParam("search", search)
                .get(TYPE_AHEAD_ENDPOINT);

    }

    public void validateSchema(Response response) {
        SchemaValidator.validateSchema(response, SUCESS_SCHEMA);
    }
}
