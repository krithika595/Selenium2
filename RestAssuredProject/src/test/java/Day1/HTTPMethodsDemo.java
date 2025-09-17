package Day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.emptyOrNullString; 

import java.util.HashMap;

import org.testng.annotations.Test;

/*
 Pre-condition --- given() --> content type,set cookies, add auth, add param, set headers info etc...
 Action/steps --- when() --> get,post,put,delete
 Validation --- then() --> validate status code, extract response,extract headers cookies & response body
 
 Validations:
   Status Code
   Response Body
   Response Time
   Content-Type
   Response String
 */

public class HTTPMethodsDemo {
	int userID;
	@Test(priority=1,enabled=false)
	void getUsers() {
		given()
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		  	.statusCode(200)
		  	.body("page", equalTo(2))
		  	.body(containsString("email"))
		  	.header("Content-type", equalTo("application/json; charset=utf-8"))
		  	.time(lessThan(2000L))
		  	.log().all();	
	}
	
	@Test(priority=2)
	void createUser() {
		HashMap<String,String> data=new HashMap<>();
		data.put("name", "Pavan");
		data.put("job", "Trainer");
		
		userID=given()
		   .contentType("application/json")
		   .body(data)
		.when()
		   .post("https://reqres.in/api/users")
		.then()
		  	.statusCode(201)
		  	.header("Content-type", equalTo("application/json; charset=utf-8"))
		  	.time(lessThan(2000L))
		  	.body("name", equalTo("Pavan"))
		  	.body("job", equalTo("Trainer"))
		  	.body(containsString("id"))
		  	.log().all()
		  	.extract().jsonPath().getInt("id");
	}
	
	@Test(priority=3, dependsOnMethods={"createUser"})
	void updateUser() {
		HashMap<String,String> data=new HashMap<>();
		data.put("name", "Krithika");
		data.put("job", "Teacher");
		
		given()
		   .contentType("application/json")
		   .body(data)
		.when()
		   .put("https://reqres.in/api/users/"+userID)
		.then()
		  	.statusCode(200)
		  	.header("Content-type", equalTo("application/json; charset=utf-8"))
		  	.time(lessThan(2000L))
		  	.body("name", equalTo("Krithika"))
		  	.body("job", equalTo("Teacher"))
		  	.log().all()
		  	.extract().jsonPath().getInt("id");
	}
	
	@Test(priority=3, dependsOnMethods={"createUser"})
	void deleteUser() {
		given()
		.when()
		   .delete("https://reqres.in/api/users/"+userID)
		.then()
		  	.statusCode(204)
		  	.time(lessThan(2000L))
		  	.body(emptyOrNullString())
		  	.log().all();
	}
}
