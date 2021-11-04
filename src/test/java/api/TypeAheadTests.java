package api;

import api.listener.ApiListener;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(ApiListener.class)
public class TypeAheadTests {

    @BeforeMethod
    public void forEachTest() {

    }

    @Test
    public void searchAValidStay() {
        String validSearch = "Walt Disney World";

        TypeAheadResource typeAheadResource = new TypeAheadResource();
        Response response = typeAheadResource.doRequest(validSearch);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("q")).isEqualTo(validSearch);
        assertThat(response.jsonPath().getList("sr")).isNotEmpty();
    }

    @Test
    public void searchAnInvalidStay() {
        String invalidSearch = "shouldreturnnothing";

        TypeAheadResource typeAheadResource = new TypeAheadResource();
        Response response = typeAheadResource.doRequest(invalidSearch);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("q")).isEqualTo(invalidSearch);
        assertThat(response.jsonPath().getList("sr")).isEmpty();
    }

    @Test
    public void emptySearch() {
        String emptySearch = "";
        String expectedRc = "ZERO_RESULTS";

        TypeAheadResource typeAheadResource = new TypeAheadResource();
        Response response = typeAheadResource.doRequest(emptySearch);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("q")).isEqualTo(emptySearch);
        assertThat(response.jsonPath().getString("rc")).isEqualTo(expectedRc);
        assertThat(response.jsonPath().getList("sr")).isEmpty();
    }

    @Test
    public void schemaTest() {
        String validSearch = "Walt Disney World";

        TypeAheadResource typeAheadResource = new TypeAheadResource();
        Response response = typeAheadResource.doRequest(validSearch);

        assertThat(response.statusCode()).isEqualTo(200);
        typeAheadResource.validateSchema(response);
    }

}
