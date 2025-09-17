package Day2;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParametersDemo {
	//@Test
	void pathParam() {
		
		given()
			.pathParam("country","India")
		
		.when()
			.get("https://restCountries.com/v2/name/{country}")
		
		.then()
			.statusCode(200)
			.log().body();
	}
	
	@Test
	void queryParam() {
		
		given()
			.queryParam("page",2)
			.queryParam("id", 5)
		
		.when()
			.get("https://reqres.in/api/users") //https://reqres.in/api/users?page=2&id=5
		
		.then()
			.statusCode(200)
			.log().body();
	}

}
