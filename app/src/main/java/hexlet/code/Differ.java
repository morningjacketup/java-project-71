package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = getDataByPath(filePath1);
        Map<String, Object> data2 = getDataByPath(filePath2);
        Map<String, Difference> treeMap = DiffBuilder.build(data1, data2);
        return Formatter.getFormat(format, treeMap);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static Map<String, Object> getDataByPath(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + pathToFile + "' does not exists");
        }
        String content = Files.readString(path);
        String extension = FilenameUtils.getExtension(pathToFile);
        return Parser.parse(extension, content);
    }
}
