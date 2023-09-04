import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Post_BodyTestingwithJSONPath {
    @Test
    public void test01(){
        //1)Request body and end point
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject addressJSONObj =new JSONObject();
        addressJSONObj.put("checkin","2023-01-10");
        addressJSONObj.put("checkout","2023-01-20");

        JSONObject requestBody=new JSONObject();
        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",addressJSONObj);
        requestBody.put("additionalneeds","wi-fi");

        //2)Expected data

        //3)Actual data
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);
        response.prettyPrint();
        //4)Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Ahmet"),
                "booking.lastname",equalTo("Bulut"),
                "booking.totalprice",equalTo(500),
                "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));
    }
}
