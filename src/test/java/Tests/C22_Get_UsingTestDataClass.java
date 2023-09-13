package Tests;

import BaseURL.BaseUrlDummyApi;
import BaseURL.BaseUrlHerokuapp;
import TestDatas.TestDataJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_Get_UsingTestDataClass extends BaseUrlDummyApi {
    @Test
    public void test01(){
        //1)Endpoint and Request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2","10");
        //2)Expected Data
        JSONObject expectedData = TestDataJsonPlaceholder.responseBodyOlustur10();

        //3)Actual Data
        Response response=given()
                .when()
                .spec(specJsonPlaceholder)
                .get("/{pp1}/{pp2}");
        response.prettyPrint();
        JsonPath responseJsonPath=response.jsonPath();
        //Aseertion
        Assert.assertEquals(TestDataJsonPlaceholder.başariliSorguStatusKodu,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));


    }
}
