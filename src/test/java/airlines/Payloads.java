package airlines;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateAirlinePayloadFromString(String id,String name,String country, String logo,
    String slogan, String head_quarters, String website, String established){

        /*
         Similarly we can parameterize the String
         content and hence the payload, but it is not good approach.
        */

        String payload = "{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": "+name+",\n" +
                "    \"country\": \"Sri Lanka\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Sri Lanka\",\n" +
                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                "    \"website\": \"www.srilankaairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";

        return payload;
    }

    public static Map getCreateAirlinePayloadFromMap(String id,String name,String country, String logo,
                                                        String slogan, String head_quarters, String website, String established){

        // Similar we can create map also for simple objects
        // and pass the payload as map.
        // Request Specification body method can accept map also.
        Map<String,Object> payload = new HashMap<>();
        payload.put("id","281199");
        payload.put("name","");
    return payload;
    }

}
