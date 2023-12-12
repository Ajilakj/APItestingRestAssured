package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Basics {
	
	public static void rest_Assured() {
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
		
		// PUT 
		String newAddress = "Summer Walk, Africa";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json").body("{\r\n"
				+"\"place_id\":\""+placeId+"\",\r\n" 
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		

		// GET 
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id",placeId)
				.when().get("maps/api/place/get/json")
				.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
			JsonPath js1=new JsonPath(getPlaceResponse);
			String actualAddress =js1.getString("address");
			System.out.println(actualAddress);
			Assert.assertEquals(actualAddress, newAddress);
		
		
//		// DELETE 
//		given().log().all().queryParam("key", "qaclick123")
//		.header("Content-Type", "application/json").body("{\r\n"
//				+ "    \"place_id\":\"3afe61be24407e805c2882c5ae17bb95\"\r\n"
//				+ "}")
//		.when().delete("/maps/api/place/delete/json")
//		.then().log().all().assertThat().statusCode(200);
	}

	public static void string_manipulation() {
		
		String str="payment $100";
		System.out.println(str.charAt(8));
		System.out.println(str.indexOf("$"));
		System.out.println(str.substring(8));
		
	}
	
	public static void main(String[] args) {
		
//		rest_Assured();
		string_manipulation();
			
	}
}
