import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C09_JSONPathKullanimi {
    @Test
    public void test01(){
        /*{
            "firstName": "John",
                "lastName": "doe",
                "address": {
            "streetAddress": "naist street",
                    "city": "Nara",
                    "postalCode": "630-0192"
        },
            "age": 26,
                "phoneNumbers": [
            {
                "number": "0123-4567-8888",
                    "type": "iphone"
            },
            {
                "number": "0123-4567-8910",
                    "type": "home"
            }
            }
    */

        JSONObject personInformation =new JSONObject();
        JSONObject addressJSONObj =new JSONObject();
        JSONArray phoneInformationArr=new JSONArray();
        JSONObject phone=new JSONObject();
        JSONObject homePhone=new JSONObject();

        addressJSONObj.put("streetAddress","naist street");
        addressJSONObj.put("city","Nara");
        addressJSONObj.put("postalCode","630-0192");

        phone.put("type","iphone");
        phone.put("number","0123-4567-8888");

        homePhone.put("type","home");
        homePhone.put("number","0123-4567-8910");

        phoneInformationArr.put(phone);
        phoneInformationArr.put(homePhone);

        personInformation.put("firstName","John");
        personInformation.put("lastName","doe");
        personInformation.put("age",26);
        personInformation.put("address",addressJSONObj);
        personInformation.put("phoneNumbers",phoneInformationArr);
        System.out.println(personInformation.get("firstName"));
        System.out.println(personInformation.getJSONObject("address").get("city"));
        System.out.println(personInformation.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));


    }
}
