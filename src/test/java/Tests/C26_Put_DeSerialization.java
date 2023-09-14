package Tests;

import BaseURL.BaseUrlDummyApi;
import TestDatas.TestDataJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C26_Put_DeSerialization extends BaseUrlDummyApi {
    @Test
    public void test01(){
        //1)Endpoint and request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");
        Map<String,Object> requestBodyMap= TestDataJsonPlaceholder.createHashMapBody(10.0,70.0,"Ahmet","Merhaba");

        //2)Expected Data
        Map<String,Object> expectedData=TestDataJsonPlaceholder.createHashMapBody(10.0,70.0,"Ahmet","Merhaba");
        //3)Actual Data
        Response response=given().spec(specJsonPlaceholder)
                .when().contentType(ContentType.JSON).body(requestBodyMap)
                .put("/{pp1}/{pp2}");

        //4)Assertion
        Map<String,Object> responseMap=response.as(HashMap.class);
        Assert.assertEquals(expectedData.get("title"),responseMap.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseMap.get("body"));
        Assert.assertEquals(expectedData.get("id"),responseMap.get("id"));
        Assert.assertEquals(expectedData.get("userId"),responseMap.get("userId"));

    }


}
