package api.steps;

import org.assertj.core.api.Assertions;

import api.RestClient;
import api.data.CommonData;
import api.enumeration.PathEnum;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class RepeatedSteps {

	CommonData commonData;
	RestClient restClient = new RestClient();
	private String jsonSchemaPath = null;
	
	public RepeatedSteps(CommonData commonData) {
		this.commonData = commonData;
	}
	
    @When("request {word} endpoint")
    public void requestTypeaheadEndpoint(String alias) {
    	PathEnum pathEnum = PathEnum.valueOf(alias.toUpperCase());
    	//Set the schema path
    	this.jsonSchemaPath = pathEnum.getJsonSchema();
    	
    	Response response = restClient.doRequest(commonData.getRequest(), pathEnum);
    	commonData.setResponse(response);
    }

    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
    	Assertions.assertThat(commonData.getResponse().statusCode()).isEqualTo(statusCode);
    }
    
    @And("schema should be correct")
    public void schemaShouldBeCorrect() {
    	restClient.validateSchema(commonData.getResponse(), jsonSchemaPath);
    }
}
