package api;

import api.enumeration.PathEnum;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	public Response doRequest(RequestSpecification request, PathEnum pathEnum) {

		request.baseUri(pathEnum.getBaseURI()).basePath(pathEnum.getBasePath());
		
        return RestAssured.given()
                .spec(request)
                .log().all()
                .when()
                .request(pathEnum.getMethod(), pathEnum.getPath())
                .then()
                .log().all()
                .extract()
                .response();
	}
	
    public void validateSchema(Response response, String path) {
        SchemaValidator.validateSchema(response, path);
    }
}
