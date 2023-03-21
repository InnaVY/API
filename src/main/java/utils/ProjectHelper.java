package utils;

import java.nio.file.Paths;

public class ProjectHelper {
    public static String getPathToRootModule(){
       String path = Paths.get(".").toAbsolutePath().getParent().toString();
        System.out.println(path);
        return path;
    }
}
