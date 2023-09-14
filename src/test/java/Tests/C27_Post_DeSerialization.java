package Tests;

import BaseURL.BaseUrlHerokuapp;
import TestDatas.TestDataHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C27_Post_DeSerialization extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        //1)Endpoint and Request Body
        specHerokuapp.pathParam("pp1","booking");
        Map<String,Object> requestBody= TestDataHerokuapp.createRequestBodyMap("Ahmet","Bulut",500.0,false,"2021-06-01","2021-06-01","wi-fi");
        //2)Expected Data
        Map<String,Object> expectedData=TestDataHerokuapp.createExpectedDataMap();
        //3)Actual Data
        Response response=given().spec(specHerokuapp)
                .when().contentType(ContentType.JSON).body(requestBody)
                .post("/{pp1}");
        //4)Assertion
        HashMap<String,Object> responseMap=response.as(HashMap.class);
        Assert.assertEquals(((Map)expectedData.get("booking")).get("firstname"),((Map)responseMap.get("booking")).get("firstname"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("lastname"),((Map)responseMap.get("booking")).get("lastname"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("totalprice"),((Map)responseMap.get("booking")).get("totalprice"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("depositpaid"),((Map)responseMap.get("booking")).get("depositpaid"));
        Assert.assertEquals(((Map)expectedData.get("booking")).get("additionalneeds"),((Map)responseMap.get("booking")).get("additionalneeds"));
        Assert.assertEquals(((Map)((Map)((Map)expectedData.get("booking"))).get("bookingdates")).get("checkin"),
                ((Map)((Map)((Map)responseMap.get("booking"))).get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)((Map)((Map)expectedData.get("booking"))).get("bookingdates")).get("checkout"),
                ((Map)((Map)((Map)responseMap.get("booking"))).get("bookingdates")).get("checkout"));




    }
}
