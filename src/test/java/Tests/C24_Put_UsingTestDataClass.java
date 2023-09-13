package Tests;

import BaseURL.BaseUrlDummyApi;
import TestDatas.TestDataJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C24_Put_UsingTestDataClass extends BaseUrlDummyApi {
    @Test
    public void test01(){
         //endpoint and request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody= TestDataJsonPlaceholder.createResponseBody(10,70,"Ahmet","Merhaba");
        //Expected data
        JSONObject expectedData=TestDataJsonPlaceholder.createResponseBody(10,70,"ahmet","Merhaba");
        //Actual data
        Response response=given().spec(specJsonPlaceholder)
                .when().contentType(ContentType.JSON).body(requestBody.toString())
                .put("/{pp1}/{pp2}");
        response.prettyPrint();
        //Assertion
        JsonPath responseJsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(response.statusCode(),TestDataJsonPlaceholder.başariliSorguStatusKodu);
        softAssert.assertEquals(response.contentType(),TestDataJsonPlaceholder.contentType);
        softAssert.assertEquals(response.header("Connection"),TestDataJsonPlaceholder.headerConnection);
        softAssert.assertEquals(responseJsonPath.get("body"),expectedData.get("body"));
        softAssert.assertAll();

    }
}
