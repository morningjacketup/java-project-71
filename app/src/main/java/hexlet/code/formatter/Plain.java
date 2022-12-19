package hexlet.code.formatter;

import hexlet.code.Difference;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;

public class Plain {
    public static String format(Map<String, Difference> proceedMap) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = new TreeSet<>(proceedMap.keySet());

        for (String key : keys) {
            switch (proceedMap.get(key).getStatus()) {
                case "added":
                    result.append("Property \'")
                            .append(key)
                            .append("\' was added with value: ")
                            .append(checkForComplexValue(proceedMap.get(key).getNewValue()))
                            .append("\n");
                    break;
                case "deleted":
                    result.append("Property \'")
                            .append(key)
                            .append("\' was removed\n");
                    break;
                case "changed":
                    result.append("Property \'")
                            .append(key)
                            .append("\' was updated. From ")
                            .append(checkForComplexValue(proceedMap.get(key).getOldValue()))
                            .append(" to ")
                            .append(checkForComplexValue(proceedMap.get(key).getNewValue()))
                            .append("\n");
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private static String checkForComplexValue(Object value) {
        if (value instanceof List | value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String | value instanceof Character) {
            return "'" + value + "'";
        }
        if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
