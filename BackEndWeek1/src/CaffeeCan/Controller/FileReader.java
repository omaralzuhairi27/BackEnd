package CaffeeCan.Controller;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Log
@UtilityClass
public class FileReader {

    public Stream<String> lines(String filePath) {
        try {
            URI uri = ClassLoader.getSystemResource(filePath).toURI();
            Path path = Paths.get(uri);
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            log.severe("Could not read the file " + filePath);
            return Stream.empty();
        }
    }

}
