import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class Main {
    static Function<String, File> directory = x -> new File("C:\\Users\\sasha\\IdeaProjects\\Games\\" + x);
    static StringBuilder sb = new StringBuilder();

    public static void createDir(String dirName) {
        File dir = directory.apply(dirName);
        if (dir.mkdir())
            System.out.println("Каталог " + dirName + " создан " + dir.getAbsolutePath());
        sb.append("\nКаталог " + dirName + " создан " + dir.getAbsolutePath());
    }

    public static void createFile(String fileName) {
        File newFile = directory.apply(fileName);
        try {
            if (newFile.createNewFile())
                System.out.println("Файл " + fileName + " создан " + newFile.getAbsolutePath());
            sb.append("\nФайл " + fileName + " создан " + newFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] directories = new String[]{"src", "res", "savegames", "temp", "src\\main", "src\\test", "res\\drawables",
                "res\\vectors", "res\\icons"};
        String[] files = new String[]{"src\\main\\Main.java", "src\\main\\Utils.java", "temp\\temp.txt"};
        for (String dir : directories) {
            createDir(dir);
        }
        for (String file : files) {
            createFile(file);
        }
        try (FileWriter writer = new FileWriter("C:\\Users\\sasha\\IdeaProjects\\Games\\temp\\temp.txt", false)) {
            writer.write(sb.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage(
            ));
        }
    }
}
