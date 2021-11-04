package api.steps;

import org.assertj.core.api.Assertions;

import api.TypeaheadResource;
import api.data.CommonData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class TypeaheadSteps {
	
	TypeaheadResource typeaheadResource = new TypeaheadResource();
	CommonData commonData;
	
	public TypeaheadSteps(CommonData commonData) {
		this.commonData = commonData;
	}
	
	
	@Given("a search for {string}")
    public void aSearchFor(String search) {
		commonData.setRequest(typeaheadResource.doRequest(search));
    }

    @And("result search should be not empty")
    public void resultSearchShouldBeNotEmpty() {
    	Assertions.assertThat(commonData.getResponse().jsonPath().getList("sr")).isNotEmpty();
    }

    @And("result search should be empty")
    public void resultSearchShouldBeEmpty() {
    	Assertions.assertThat(commonData.getResponse().jsonPath().getList("sr")).isEmpty();
    }
}
