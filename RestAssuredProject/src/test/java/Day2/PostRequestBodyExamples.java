package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test; 
public class PostRequestBodyExamples {
	String studentID;

	
	//1) create post request body using HashMap
	//@Test
	void createStudentUsingHashMap() {
		HashMap<String,Object> requestBody=new HashMap<>();
		requestBody.put("name", "Krithi");
		requestBody.put("location", "India");
		requestBody.put("phone", 123456789);
		
		String courses[]= {"C","C++"};
		requestBody.put("courses",courses);
		
		
		studentID=given()
			.contentType("application/json")
			.body(requestBody)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Krithi"))
			.body("location", equalTo("India"))
			.body("phone", equalTo(123456789))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type","application/json")
			.log().body()
			.extract().jsonPath().getString("id");
	}
	
	//2) create post request body using org.json library
	
	//@Test
	void createStudentUsingJsonLibrary() {
		
		JSONObject requestBody=new JSONObject();
		requestBody.put("name", "Krithi");
		requestBody.put("location", "India");
		requestBody.put("phone", 123456789);
		
		String courses[]= {"C","C++"};
		requestBody.put("courses",courses);
		
		studentID=given()
			.contentType("application/json")
			.body(requestBody.toString())
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Krithi"))
			.body("location", equalTo("India"))
			.body("phone", equalTo(123456789))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type","application/json")
			.log().body()
			.extract().jsonPath().getString("id");
	}
	
	//3) create post request body using POJO Class
	@Test
	void createStudentUsingPojoClass() {
		
		StudentPojo requestBody=new StudentPojo();
		requestBody.setName("Krithi");
		requestBody.setLocation("India");
		requestBody.setPhone("123456789");
		
		String courses[]= {"C","C++"};
		requestBody.setCourses(courses);
		
		studentID=given()
			.contentType("application/json")
			.body(requestBody)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo(requestBody.getName()))
			.body("location", equalTo(requestBody.getLocation()))
			.body("phone", equalTo(requestBody.getPhone()))
			.body("courses[0]", equalTo(requestBody.getCourses()[0]))
			.body("courses[1]", equalTo(requestBody.getCourses()[1]))
			.header("Content-Type","application/json")
			.log().body()
			.extract().jsonPath().getString("id");
	}
	
	//4) create post request body using External JSON File
		@Test
		void createStudentUsingExternalFile() throws FileNotFoundException {
			
			File myFile=new File(".\\src\\test\\java\\Day2\\body.json");
			FileReader fileReader=new FileReader(myFile);
			
			JSONTokener jsonTokener=new JSONTokener(fileReader);
			JSONObject requestBody=new JSONObject(jsonTokener);
			
			studentID=given()
				.contentType("application/json")
				.body(requestBody.toString())
			
			.when()
				.post("http://localhost:3000/students")
			
			.then()
				.statusCode(201)
				.body("name", equalTo("Krithi"))
				.body("location", equalTo("India"))
				.body("phone", equalTo("123456789"))
				.body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++"))
				.header("Content-Type","application/json")
				.log().body()
				.extract().jsonPath().getString("id");
		}
		
	
	
	@AfterMethod
	void deleteStudentMethod() {
		given()
		
		.when()
			.delete("http://localhost:3000/students/"+studentID)
		
		.then()
			.statusCode(200);
	}
}
