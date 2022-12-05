package hexlet.code.formatter;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.List;

public class Plain {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = "";
        Set<String> keys = new TreeSet<>(proceedMap.keySet());
        map1 = preparingMap(map1);
        map2 = preparingMap(map2);

        for (String key : keys) {
            switch (proceedMap.get(key)) {
                case "added":
                    result += "Property \'" + key + "\' was added with value: " + map2.get(key) + "\n";
                    break;
                case "deleted":
                    result += "Property \'" + key + "\' was removed\n";
                    break;
                case "changed":
                    result += "Property \'" + key
                            + "\' was updated. From "
                            + map1.get(key)
                            + " to "
                            + map2.get(key) + "\n";
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return result;
    }

    private static Map<String, Object> preparingMap(Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();

        for (Map.Entry<String, Object> item : map.entrySet()) {
            String key = item.getKey();
            var value = map.get(key);
            if (value instanceof String || value instanceof Character) {
                resultMap.put(key, "\'" + value + "\'");
            } else if (value == null) {
                resultMap.put(key, null);
            } else if (value instanceof List || value instanceof Map) {
                resultMap.put(key, "[complex value]");
            } else {
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }
}
