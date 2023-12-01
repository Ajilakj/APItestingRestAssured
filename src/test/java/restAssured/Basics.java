package restAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		// POST 
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
		// PUT 
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "b60776a46df67a8b1e64812c2ef5aa18")
		.header("Content-Type", "application/json").body("{\r\n"
				+ "\"place_id\":\"b60776a46df67a8b1e64812c2ef5aa18\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200);
		

		// GET 
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "3afe61be24407e805c2882c5ae17bb95")
		.header("Content-Type", "application/json")
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);
		
		
		// DELETE 
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json").body("{\r\n"
				+ "    \"place_id\":\"3afe61be24407e805c2882c5ae17bb95\"\r\n"
				+ "}")
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);
		
		

			
	}
}
