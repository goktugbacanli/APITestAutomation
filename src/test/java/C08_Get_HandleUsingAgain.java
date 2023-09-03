import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C08_Get_HandleUsingAgain {
    @Test
    public void test01(){
        //1)Endpoint and Request body
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2)Expected Data
        //3)Actual Data
        Response response=given().when().get(url);
        response.prettyPrint();
        //4)Assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Sally"))
                .body("lastname", equalTo("Jones"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid", equalTo(false))
                .body("additionalneeds",Matchers.notNullValue());
    }
    @Test
    public void test02(){
        //1)Endpoint and Request body
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2)Expected Data
        //3)Actual Data
        Response response=given().when().get(url);
        response.prettyPrint();
        //4)Assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Sally"),
                "lastname",equalTo("Jackson"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(false),
                        "additionalneeds",nullValue());




    }
}
