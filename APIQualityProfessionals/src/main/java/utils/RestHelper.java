package utils;

import Endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestHelper {
    public static void restPostRequestWithBody(String baseURL, Object requestBody, EndPoints endPoint, int status){
         RestAssured.given()
                .body(requestBody)
                .header("Content-Type", "application/json")
                .when().post(baseURL.concat(endPoint.value))
                .then().assertThat().statusCode(status);
    }
    public static void restPostRequestWithoutBody(String baseURL, EndPoints endPoint, int status){
        RestAssured.given()
                .header("Content-Type", "application/json")
                .when().post(baseURL.concat(endPoint.value))
                .then().assertThat().statusCode(status);
    }
}
