package airlines;

import io.restassured.response.Response;
import restutils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPI {
    public Response createAirline(Map<String,Object> createAirlinePayload){
        String endPoint = (String)BaseTest.dataFromJsonFile.get("createAirlineEndpoint");
       return RestUtils.performPost(endPoint,createAirlinePayload,new HashMap<>());
    }
}
