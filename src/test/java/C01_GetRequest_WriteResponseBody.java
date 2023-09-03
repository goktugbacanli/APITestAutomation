
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_WriteResponseBody {

    @Test
            public void get01(){
    //1)Request Body ve end-point hazirma
    String url="https://restful-booker.herokuapp.com/booking/1";
    //2)Expected data hazırlama

    //3)Request gönderip, dönen response'i kaydetme
        Response response=given().when().get(url);
        response.prettyPrint();
    //4)Karşılaştırma

    }
}
