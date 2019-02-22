package CaffeeCan.Controller;

import CaffeeCan.Modle.Bean;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
@UtilityClass
public class WritingFiles {


    public static void write(List<String> lines, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  void append(List<String> lines, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
