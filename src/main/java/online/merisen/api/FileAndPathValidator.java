package online.merisen.api;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;

public class FileAndPathValidator {
    public static ArrayList<String> validateFiles = new ArrayList<>();

    public static void validatePath(String path) {
        if (Files.exists(Paths.get(path))) {
            System.out.println("[FILES AND PATH VALIDATOR] Path " + path + " exist!");
        } else {
            System.out.println("[FILES AND PATH VALIDATOR] Path didn't exists! Creating Working Dir path");
            new File(path).mkdir();
        }
    }

    public static void validateFilesInWorkingDir(String path) {
        File workingDir = new File(path);
        File[] filesInWorkingDir = workingDir.listFiles();
        validateFiles.add("spacedevs-astronaut-id.json");
        validateFiles.add("iss-astronaut-name.json");
        validateFiles.add("spacedevs-astronauts-nationality.json");
        validateFiles.add("spacedevs-all-astronauts.json");
        validateFiles.add("international-space-station-location.json");
        validateFiles.add("get-astronauts-query-iss.json");
        validateFiles.add("spacedevs-astronaut-name.json");
        validateFiles.add("iss-all-astronauts.json");
        validateFiles.add("iss-location-google-api.json");
        validateFiles.add("iss-craft-astronauts.json");
        validateFiles.add("all-astronauts.json");
        validateFiles.add("get-astronauts-query-space.json");
        validateFiles.add("spacedevs-astronauts-agency.json");
        validateFiles.add("google-maps-link-shorter.json");
        validateFiles.add("google-maps-link.json");

        System.out.println("[FILES AND PATH VALIDATOR] List of files and directories in the specified directory:");
        if (filesInWorkingDir != null) {
            for (File file : filesInWorkingDir) {
                System.out.println("File name: " + file.getName());
                System.out.println("File path: " + file.getAbsolutePath());
                System.out.println(" ");
            }
        } else {
            for (String validateFile : validateFiles) {
                File file = new File(path + validateFile);
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
