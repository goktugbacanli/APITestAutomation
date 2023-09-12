package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Put_ExpectedDataTestingwithSoftAssert {
    @Test
    public void test01(){
        //1)endpoint and request body
        String url="http://dummy.restapiexample.com/api/v1/update/3";
        JSONObject requestBody=new JSONObject();
        JSONObject dataInf =new JSONObject();
        dataInf.put("name","Ahmet");
        dataInf.put("salary","1230");
        dataInf.put("age","44");
        dataInf.put("id",40);
        requestBody.put("status","success");
        requestBody.put("data",dataInf);

        //2)Expected Data
        JSONObject expectedData =new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Succesfully! Record has been updated.");


        //3)Actual Data
        Response response =given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .put(url);
        response.prettyPrint();
        //4)Assertion
        JsonPath responseJSONPath =response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJSONPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJSONPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJSONPath.get("data.status"),expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJSONPath.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJSONPath.get("data.data.salary"),expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJSONPath.get("data.data.age"),expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertAll();


    }
}
