package Tests;

import BaseURL.BaseUrlDummyApi;
import TestDatas.TestDataJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_UsingTestDataAsDynamic extends BaseUrlDummyApi {
    @Test
    public void test01(){
        //endpoint and request body
    specJsonPlaceholder.pathParams("pp1","posts","pp2","40");
    //expected data
        JSONObject expectedData=TestDataJsonPlaceholder.createResponseBody(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");
    //Actual data
        Response response=given()
                .when()
                .spec(specJsonPlaceholder)
                .get("/{pp1}/{pp2}");
        response.prettyPrint();
        JsonPath responseJsonPath=response.jsonPath();
        //Assertion
        Assert.assertEquals(TestDataJsonPlaceholder.başariliSorguStatusKodu,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));

    }
}
