package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Post_ExpectedDataAndJsonPathwithAssertion {
   @Test
    public void test01(){
       /*
       Expected data
  {
    "booking": {
      "firstname": "Ahmet",
      "additionalneeds": "wi-fi",
      "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
      },
      "totalprice": 500,
      "depositpaid": false,
      "lastname": "Bulut"
    },
    "bookingid": 24
  }
    Response data
{
    "bookingid": 1443,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}
*/


       //1)EndPoint and Request Body
       String url="https://restful-booker.herokuapp.com/booking";
       JSONObject requestBody =new JSONObject();
       JSONObject bookingDatesJSONObj= new JSONObject();
       bookingDatesJSONObj.put("checkin","2021-06-01");
       bookingDatesJSONObj.put("checkout","2021-06-10");

       requestBody.put("firstname","Ahmet");
       requestBody.put("lastname","Bulut");
       requestBody.put("totalprice",500);
       requestBody.put("depositpaid",false);
       requestBody.put("bookingdates",bookingDatesJSONObj);
       requestBody.put("additionalneeds","wi-fi");



       //2)Expected Data
        JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);
       System.out.println(expectedData);

       //3)Actual Data
       Response response=given()
               .contentType(ContentType.JSON)
               .when()
               .body(requestBody.toString())
               .post(url);
       response.prettyPrint();
       JsonPath responseJSONPath =response.jsonPath();
       //4)Assertion
       Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),
               responseJSONPath.get("booking.firstname"));
      Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"),
              responseJSONPath.get("booking.lastname"));
      Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
              responseJSONPath.get("booking.totalprice"));
      Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
              responseJSONPath.get("booking.depositpaid"));
      Assert.assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
              responseJSONPath.get("booking.additionalneeds"));
      Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
              responseJSONPath.get("booking.bookingdates.checkin"));
      Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
              responseJSONPath.get("booking.bookingdates.checkout"));
   }


}
