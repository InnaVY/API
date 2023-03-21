package properties.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources("file:${root_module_path}/src/main/resources/instances/users.properties")
public interface UsersService extends Config {
    @Key ("user.path")
    String getUserPath();

    @Key ("host")
    String getHost(String env);
}
