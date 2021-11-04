package api;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidator {

    public static void validateSchema(Response response, String jsonSchemaPath) {
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonSchemaPath));
    }
}
