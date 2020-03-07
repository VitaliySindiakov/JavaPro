package Lesson3Home;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "C:\\temp\\Lesson3Home.txt")
public class Container {
    String s = "Hello world";

    @Saver
    public void save(String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(s);
        } catch (IOException e) {
            System.out.println("No such directory - make sure you write correct path to file");
            StringBuilder stringBuilder = new StringBuilder(path);
            String dirPath = stringBuilder.substring(0,stringBuilder.lastIndexOf("\\"));
            File dir = new File(dirPath);
            dir.mkdirs();
            File file = new File(path);
            file.createNewFile();
            save(file.getAbsolutePath());
        }
    }
}
