package restutils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response performPost(String endPoint, String requestPayload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,requestPayload,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Map<String,Object> requestPayload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,requestPayload,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload,Map<String,String> headers){
       return given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        queryableRequestSpecification.getBaseUri();
        ExtentReportUtils.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportUtils.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportUtils.logInfoDetails("Headers are " + queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportUtils.logInfoDetails("Request body is " + queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){

        ExtentReportUtils.logInfoDetails("Response Status is " + response.getStatusCode());
        ExtentReportUtils.logInfoDetails("Response Header is " + response.getHeaders().asList().toString());
        ExtentReportUtils.logInfoDetails("Response body is " + response.getBody());
    }


}
