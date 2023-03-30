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
        if (System.getenv("ACCESS_TOKEN")==null){
            accessToken = "634dc247bf42f31fa4c84a4a235f0d3358588fd48d7221e21ada77e7f126f946";
        } else {
            accessToken = System.getenv("ACCESS_TOKEN");
        }
        return accessToken;
    }
}
