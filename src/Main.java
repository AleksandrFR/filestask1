import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class Main {
    static Function<String, File> directory = x -> new File("C:\\Users\\sasha\\IdeaProjects\\Games\\" + x);
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        String[] directories = new String[]{"src", "res", "savegames", "temp", "src\\main", "src\\test", "res\\drawables",
                "res\\vectors", "res\\icons"};
        String[] files = new String[]{"src\\main\\Main.java", "src\\main\\Utils.java", "temp\\temp.txt"};

        Function<String, File> newDirFile = x -> directory.apply(x);

        for (String dirName : directories) {
            File dir = newDirFile.apply(dirName);
            if (dir.mkdir()) {
                System.out.println("Каталог " + dir + " создан " + dir.getAbsolutePath());
                sb.append("\nКаталог " + dir + " создан " + dir.getAbsolutePath());
            }
        }

        for (String fileName : files) {
            File file = newDirFile.apply(fileName);
            try {
                if (file.createNewFile())
                    System.out.println("Файл " + fileName + " создан " + file.getAbsolutePath());
                sb.append("\nФайл " + fileName + " создан " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter("C:\\Users\\sasha\\IdeaProjects\\Games\\temp\\temp.txt", false)) {
            writer.write(sb.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage(
            ));
        }
    }
}
