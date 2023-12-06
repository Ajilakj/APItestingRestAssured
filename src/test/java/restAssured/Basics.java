package restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import files.Payload;

public class Basics {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		// POST 
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response); //for parsing Json
		String placeId=js.getString("place_id");
		
		System.out.println(placeId);
		
//		// PUT 
//		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "b60776a46df67a8b1e64812c2ef5aa18")
//		.header("Content-Type", "application/json").body("{\r\n"
//				+ "\"place_id\":\"b60776a46df67a8b1e64812c2ef5aa18\",\r\n"
//				+ "\"address\":\"70 Summer walk, USA\",\r\n"
//				+ "\"key\":\"qaclick123\"\r\n"
//				+ "}")
//		.when().put("/maps/api/place/update/json")
//		.then().log().all().assertThat().statusCode(200);
//		
//
//		// GET 
//		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "3afe61be24407e805c2882c5ae17bb95")
//		.header("Content-Type", "application/json")
//		.when().get("/maps/api/place/get/json")
//		.then().log().all().assertThat().statusCode(200);
//		
//		
//		// DELETE 
//		given().log().all().queryParam("key", "qaclick123")
//		.header("Content-Type", "application/json").body("{\r\n"
//				+ "    \"place_id\":\"3afe61be24407e805c2882c5ae17bb95\"\r\n"
//				+ "}")
//		.when().delete("/maps/api/place/delete/json")
//		.then().log().all().assertThat().statusCode(200);
		
		

			
	}
}
