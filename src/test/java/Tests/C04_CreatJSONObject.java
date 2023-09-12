package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_CreatJSONObject {
    @Test
    public void test01(){
        JSONObject object=new JSONObject();
        object.put("title","Göktuğ");
        object.put("body","merhaba");
        object.put("userId",1);
        System.out.println(object);

        JSONObject dateJSONObject =new JSONObject();
        dateJSONObject.put("checkin","2018-01-01");
        dateJSONObject.put("checkout","2019-01-01");

        JSONObject requestBody =new JSONObject();
        requestBody.put("fistname","Jim");
        requestBody.put("additionaldates","Breakfast");
        requestBody.put("bookingdates",dateJSONObject);
        requestBody.put("totalprice",111);
        requestBody.put("depositpaid",true);
        requestBody.put("lastname","Brown");
        System.out.println(requestBody);

    }
}
