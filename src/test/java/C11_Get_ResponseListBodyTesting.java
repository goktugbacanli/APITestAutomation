import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Get_ResponseListBodyTesting {
    @Test
    public void test01() {

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        Response response = given()
                .when()
                .get(url);
        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("status", equalTo("success"),
                        "data.id",hasItem(1));
    }
}
