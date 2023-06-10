package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response performPost(String endPoint, String requestPayload, Map<String,String> headers){

        Response response = given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then().log().all().extract().response();

        return response;

    }

    public static Response performPost(String endPoint, Map<String,Object> requestPayload, Map<String,String> headers){

        Response response = given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then().log().all().extract().response();

        return response;

    }

}
