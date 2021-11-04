package api.data;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonData {

	
	ThreadLocal<RequestSpecification> request = new ThreadLocal<>();
	
	ThreadLocal<Response> response = new ThreadLocal<>();
	
	public RequestSpecification getRequest() {
        return request.get();
    }

    public void setRequest(RequestSpecification request) {
        this.request.set(request);
    }

    public Response getResponse() {
        return response.get();
    }

    public void setResponse(Response response) {
        this.response.set(response);
    }
}
