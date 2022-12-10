package hexlet.code.formatter;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = "{\n";
        for (Map.Entry<String, String> item : proceedMap.entrySet()) {
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
        result += "}\n";
        return result;
    }
}
