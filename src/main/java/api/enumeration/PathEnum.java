package api.enumeration;

import io.restassured.http.Method;

public enum PathEnum {
	
	TYPEAHEAD("https://www.expedia.com","/api/v4","/typeahead/{search}",Method.GET, "schemas/typeahead/typeahead_sucess.json");
	
	
	PathEnum(String baseURI, String basePath, String path, Method method, String jsonSchema) {
		this.baseURI = baseURI;
		this.basePath = basePath;
		this.path = path;
		this.method = method;
		this.jsonSchema = jsonSchema;
	}

	private String baseURI;
	
	private String basePath;
	
    private String path;

    private Method method;
    
    private String jsonSchema;

	public String getBaseURI() {
		return baseURI;
	}

	public String getBasePath() {
		return basePath;
	}

	public String getPath() {
		return path;
	}

	public Method getMethod() {
		return method;
	}

	public String getJsonSchema() {
		return jsonSchema;
	}
}
