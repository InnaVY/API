package base_api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import models.User;
import models.UserRequest;

import static properties.PropertyHolder.usersServiceProperty;
import static utils.EnvironmentVariableHandler.getAccessToken;
import static utils.EnvironmentVariableHandler.getEnv;

public class UsersApi {
    private RequestSpecification spec;
    private static UsersApi defaultInstance;
    String usersPath = usersServiceProperty.getUserPath();

private UsersApi(String baseUrl){
    //    PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
//        auth.setUserName("provided_username");
//        auth.setPassword("provided_password");

    PreemptiveOAuth2HeaderScheme auth = new PreemptiveOAuth2HeaderScheme();

    auth.setAccessToken(getAccessToken());
    spec = new RequestSpecBuilder()
            .addFilter(new AllureRestAssured())
            .setAuth(auth)
            .setContentType(ContentType.JSON)
            .setBaseUri(baseUrl)
            .setBasePath(usersPath)
            .build();
}

  public static UsersApi getDefaultInstance(){
    if (defaultInstance == null){
        String host = usersServiceProperty.getHost(getEnv());
        return new UsersApi(host);
    }
    return defaultInstance;
  }

    public Response getAllUsers(){
        return  RestAssured.given().spec(spec).when().get();

    }


    public Response getUser(int id){
        return RestAssured.given().spec(spec).when().get("/"+id);
    }

    public Response createFakeUser(){
        return RestAssured.given().spec(spec).when()
                .body(UserRequest.create()).post();
    }


}
