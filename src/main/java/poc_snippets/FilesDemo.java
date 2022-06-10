package poc_snippets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\dummy\\new-file.txt");
        Files.createFile(path);
        System.out.println("File created successfully");
    }
}
