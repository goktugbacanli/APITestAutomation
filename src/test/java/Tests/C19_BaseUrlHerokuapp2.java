package Tests;

import BaseURL.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C19_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {
    @Test
        public void test01(){
        //1)Endpoint and Request body
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");
        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds","wi-fi");
        //2)Expected Value
        //3)Actual Value
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .spec(specHerokuapp)
                .body(requestBody.toString())
                .post("/{pp1}");
        response.prettyPrint();
        //4)Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", equalTo("Ahmet"));

    }
}
