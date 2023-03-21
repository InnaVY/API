
import logger.TestLogger;
import models.User;
import org.testng.annotations.Test;

import java.util.List;

import static base_api.ApiSteps.*;

public class UsersTests {

    @Test(description = "Get all users and retrieve information for the first")
    public void usersTests(){
        List<User> users =  getAllUsers();
        int id = users.get(0).getId();
        System.out.println("Before log");
        TestLogger.logAction("User id = %d", id);
        getUser(id);
    }

}
