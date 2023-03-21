package properties;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigFactory;
import properties.interfaces.UsersService;

import static utils.ProjectHelper.getPathToRootModule;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class PropertyHolder {

    static{
        configureUserPath();
    }

   public static final UsersService usersServiceProperty = ConfigFactory.create(UsersService.class);
    private static void configureUserPath(){
        System.setProperty("root_module_path", getPathToRootModule());
    }

}
