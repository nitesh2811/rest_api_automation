package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class AirlineTest extends AirlineAPI {
    @Test
    public void createAirlineTest() {
        // String payLoad = Payloads.getCreateAirlinePayloadFromString("","","","","","","","");
        Map<String, Object> payLoad = Payloads.getCreateAirlinePayloadFromMap("", "", "", "", "", "", "", "");
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
