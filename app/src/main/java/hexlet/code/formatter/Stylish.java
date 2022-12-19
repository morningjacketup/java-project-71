package hexlet.code.formatter;

import hexlet.code.Difference;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, Difference> proceedMap) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Difference> item : proceedMap.entrySet()) {
            String key = item.getKey();
            switch (item.getValue().getStatusName()) {
                case "added":
                    result.append("  " + "+ " + key + ": " + proceedMap.get(key).getNewValue() + "\n");
                    break;
                case "deleted":
                    result.append("  " + "- " + key + ": " + proceedMap.get(key).getOldValue() + "\n");
                    break;
                case "changed":
                    result.append("  " + "- " + key + ": " + proceedMap.get(key).getOldValue() + "\n");
                    result.append("  " + "+ " + key + ": " + proceedMap.get(key).getNewValue() + "\n");
                    break;
                case "unchanged":
                    result.append("  " + "  " + key + ": " + proceedMap.get(key).getOldValue() + "\n");
                    break;
                default:
                    throw new RuntimeException("operation not found");
            }
        }
        result.append("}");
        return result.toString();
    }
}
