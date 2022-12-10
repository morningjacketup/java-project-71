package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> map1 = Parser.parse(filePath1);
        Map<String, Object> map2 = Parser.parse(filePath2);
        Map<String, String> map = compare(map1, map2);
        return Formatter.getFormat(format, map, map1, map2);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> map1 = Parser.parse(filePath1);
        Map<String, Object> map2 = Parser.parse(filePath2);
        Map<String, String> map = compare(map1, map2);
        return Formatter.getFormat("stylish", map, map1, map2);
    }

    public static Map<String, String> compare(final Map<String, Object> map1, final Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        Map<String, String> proceedMap = new TreeMap<>();

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                proceedMap.put(key, "added");
            } else if (!map2.containsKey(key)) {
                proceedMap.put(key, "deleted");
            } else if (!(Objects.equals(map1.get(key), map2.get(key)))) {
                proceedMap.put(key, "changed");
            } else {
                proceedMap.put(key, "unchanged");
            }
        }
        return proceedMap;
    }
}
