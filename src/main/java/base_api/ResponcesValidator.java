package base_api;

import io.restassured.response.Response;

import static org.apache.http.HttpStatus.SC_OK;

public class ResponcesValidator {

    public static void success(Response response){
        response.then().statusCode(SC_OK).log().all();
    }
}
