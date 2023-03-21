package utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EnvironmentVariableHandler {

    public static String getEnv(){
        String env;
        if(System.getenv("ENV")==null){
            env = "gorest.co.in";
        } else {
            env = System.getenv("ENV");
        }
        return env;
    }

    public static String getAccessToken(){
        String accessToken;
        if (System.getenv()==null){
            accessToken = "6e398124a1dd58b3e41e21ec5e41a269137a8771586f4fc839091bcc99606ed3";
        } else {
            accessToken = System.getenv("ACCESS_TOKEN");
        }
        return accessToken;
    }
}
