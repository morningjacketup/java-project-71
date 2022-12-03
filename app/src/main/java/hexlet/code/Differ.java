package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath, String filePath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get(filePath);
        Path path2 = Paths.get(filePath2);

        String data = Files.readString(path);
        String data2 = Files.readString(path2);

        Map<String, Object> map1 = new HashMap<>(mapper.readValue(data, new TypeReference<>() {}));
        Map<String, Object> map2 = new HashMap<>(mapper.readValue(data2, new TypeReference<>() {}));

        Map<String, String> resultList = Comparer.compare(map1, map2);
        String result = "{\n";
        Map<String, Object> res = new HashMap<>(resultList);
            for (Map.Entry<String, String> item : resultList.entrySet()) {
                String key = item.getKey();
                switch (item.getValue()) {
                    case "added":
                        result += " " + "+ " + key + ": " + map2.get(key) + "\n";
                        break;
                    case "deleted":
                        result += " " + "- " + key + ": " + map1.get(key) + "\n";
                        break;
                    case "changed":
                        result += " " + "- " + key + ": " + map1.get(key) + "\n";
                        result += " " + "+ " + key + ": " + map2.get(key) + "\n";
                        break;
                    case "unchanged":
                        result += " " + "  " + key + ": " + map1.get(key) + "\n";
                        break;
                    default:
                        throw new RuntimeException("operation not found");
                }
            }
            result += "}";
            return result;
    }
}
