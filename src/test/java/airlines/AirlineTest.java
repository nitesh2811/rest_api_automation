package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineTest {

    @Test
    public void createAirlineTest(){

        String endPoint = "https://api.instantwebtools.net/v1/airlines";
       // String payLoad = Payloads.getCreateAirlinePayloadFromString("","","","","","","","");
        Map<String,Object> payLoad = Payloads.getCreateAirlinePayloadFromMap("","","","","","","","");
        Response response = RestUtils.performPost(endPoint,payLoad,new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);



    }
}
