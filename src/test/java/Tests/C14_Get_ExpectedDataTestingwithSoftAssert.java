package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Get_ExpectedDataTestingwithSoftAssert {
    @Test
    public void test01(){
        //1)Endpoint and RequestBody
        String url="http://dummy.restapiexample.com/api/v1/employees/3";

        //2)Expected Data
        JSONObject expectedData=new JSONObject();
        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put("employee_name","AshtonCox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");
        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been fetched.");
        System.out.println(expectedData.toString());
        //3)Actual Data
        Response response=given()
                .when()
                .get(url);
        response.prettyPrint();
        //4)Assertion
        JsonPath responseJsonpath =response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJsonpath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonpath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonpath.get("data.id"),expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonpath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonpath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonpath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonpath.get("profile_image"),expectedData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();

    }
}
