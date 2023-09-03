import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Get_ResponseBodyAutomationTesting {
    @Test
    public void test01(){
        //1)Request body ve endpoint
        String url="https://jsonplaceholder.typicode.com/posts/70";
        //2)Expected Data

        //3)Actual data
        Response response=given().when().get(url);
        response.prettyPrint();
        //4)Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",Matchers.equalTo(7))
                .body("title",Matchers.equalTo("voluptatem laborum magni"));


    }
}
