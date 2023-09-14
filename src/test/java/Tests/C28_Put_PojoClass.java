package Tests;

import BaseURL.BaseUrlDummyApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C28_Put_PojoClass extends BaseUrlDummyApi {
    @Test
    public void test01(){
        //1)Request body and endpoints
        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");
        PojoJsonPlaceHolder requestBodyPojo=new PojoJsonPlaceHolder("Ahmet","merhaba",10,70);
        //2)Expected data
        PojoJsonPlaceHolder expectedDataPojo=new PojoJsonPlaceHolder("Ahmet","merhaba",10,70);
        //3)Actual data
        Response response= given().spec(specJsonPlaceholder)
                .when().contentType(ContentType.JSON).body(requestBodyPojo)
                .put("/{pp1}/{pp2}");

        PojoJsonPlaceHolder responsePojo=response.as(PojoJsonPlaceHolder.class);
        //4)Assertion
        Assert.assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        Assert.assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        Assert.assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        Assert.assertEquals(expectedDataPojo.getId(),responsePojo.getId());

    }

}
