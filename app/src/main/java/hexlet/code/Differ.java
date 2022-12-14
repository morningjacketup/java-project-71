package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> map1 = getFile(filePath1);
        Map<String, Object> map2 = getFile(filePath2);
        Map<String, String> treeMap = Tree.build(map1, map2);
        return Formatter.getFormat(format, treeMap, map1, map2);
    }

    private static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static Map<String, Object> getFile(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + pathToFile + "' does not exists");
        }
        String fileContent = Files.readString(path);
        String fileType = FilenameUtils.getExtension(pathToFile);
        return Parser.parse(fileType, fileContent);
    }
}
