package base_api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.User;

import java.util.Arrays;
import java.util.List;

import static base_api.ResponcesValidator.success;

public class ApiSteps {
    private static UsersApi usersApi = UsersApi.getDefaultInstance();

@Step("Get all users")
public static List<User> getAllUsers(){
Response usersResponse =  usersApi.getAllUsers();
    success(usersResponse);
List<User> users = Arrays.asList(usersResponse.getBody().as(User[].class));
return users;
}

@Step ("Return data for user with id: {0}")
    public static  User getUser(int id){
    Response userResponse =  usersApi.getUser(id);
    success(userResponse);
    return userResponse.body().as(User.class);
}

}
