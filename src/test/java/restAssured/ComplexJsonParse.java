package restAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	@Test
	public void complexJsonParse () {
		JsonPath js=new JsonPath(Payload.coursePrice());
		
		int count=js.getInt("courses.size()");
//		System.out.println("Print No of courses returned by API :"+count);
		
		int amt=js.getInt("dashboard.purchaseAmount");
//		System.out.println("Print Purchase Amount :"+amt);
		
		String title = js.getString("courses[0].title");
		System.out.println("Print Title of the first course: "+title);
		
		System.out.println("Print All course titles and their respective Prices: "+title);
		for(int i=0;i<count;i++) {
//			System.out.println("Title of the course"+(i+1)+ " :"+(js.getString("courses["+i+"].title")));
			System.out.println("Price of the course"+(i+1)+ " :"+(js.getInt("courses["+i+"].price")));
		}
		
		for(int i=0;i<count;i++) {
			String course=js.getString("courses["+i+"].title");
			if(course.equalsIgnoreCase("RPA")){
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("Print no of copies sold by RPA Course: "+copies);
				break;
			}
		}
		
		int purchaseAmt=0;
		for(int i=0;i<count;i++) {
			int copy=js.getInt("courses["+i+"].copies");
			int price=js.getInt("courses["+i+"].price");
			purchaseAmt=purchaseAmt+=(copy*price);
		}
		System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
		System.out.println("Calculated Purchase Amount:"+purchaseAmt);
		System.out.println("Purchase Amount rom API:"+amt);
		Assert.assertEquals(purchaseAmt, amt);
	}
}
