package Tests;

import BaseURL.BaseUrlDummyApi;
import BaseURL.BaseUrlHerokuapp;
import TestDatas.TestDataHerokuapp;
import TestDatas.TestDataJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C25_Post_UsingTestDataClassComplex extends BaseUrlHerokuapp {
    @Test
    public void test01(){
    //1)Endpoint and Request body
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody= TestDataHerokuapp.createRequestBody("Ahmet","Bulut",500,false,"2021-06-01","2021-06-10","wi-fi");
    //2)Expected Data
        JSONObject expectedBody= TestDataHerokuapp.createExpectedData(11,"Ahmet","Bulut",500,false,"2021-06-01","2021-06-10","wi-fi");
    //3)Actual Data
        Response response=given().spec(specHerokuapp)
                .when().contentType(ContentType.JSON).body(requestBody.toString())
                .post("/{pp1}");

    //4)Assertion
        JsonPath responseJSONPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJSONPath.getString("booking.firstname"),expectedBody.getJSONObject("booking").getString("firstname"));
        softAssert.assertEquals(responseJSONPath.getString("booking.lastname"),expectedBody.getJSONObject("booking").getString("lastname"));
        softAssert.assertEquals(responseJSONPath.getInt("booking.totalprice"),expectedBody.getJSONObject("booking").getInt("totalprice"));
        softAssert.assertEquals(responseJSONPath.getBoolean("booking.depositpaid"),expectedBody.getJSONObject("booking").getBoolean("depositpaid"));
        softAssert.assertEquals(responseJSONPath.getString("booking.additionalneeds"),expectedBody.getJSONObject("booking").getString("additionalneeds"));
        softAssert.assertEquals(responseJSONPath.getString("booking.bookingdates.checkin"),expectedBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"));
        softAssert.assertEquals(responseJSONPath.getString("booking.bookingdates.checkout"),expectedBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"));
        softAssert.assertAll();

    }
}
