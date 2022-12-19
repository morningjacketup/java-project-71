package hexlet.code.formatter;

import hexlet.code.Difference;

import java.util.Map;

import static hexlet.code.Difference.ADDED;
import static hexlet.code.Difference.DELETED;
import static hexlet.code.Difference.CHANGED;
import static hexlet.code.Difference.UNCHANGED;

public class Stylish {
    public static String format(Map<String, Difference> proceedMap) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Difference> item : proceedMap.entrySet()) {
            String key = item.getKey();
            switch (item.getValue().getStatusName()) {
                case ADDED:
                    Object addedValue = proceedMap.get(key).getNewValue();
                    result.append("  + " + key + ": " + addedValue + "\n");
                    break;
                case DELETED:
                    Object deletedValue = proceedMap.get(key).getOldValue();
                    result.append("  - " + key + ": " + deletedValue + "\n");
                    break;
                case CHANGED:
                    Object oldValue = proceedMap.get(key).getOldValue();
                    Object newValue = proceedMap.get(key).getNewValue();
                    result.append("  - " + key + ": " + oldValue + "\n");
                    result.append("  + " + key + ": " + newValue + "\n");
                    break;
                case UNCHANGED:
                    Object unchangedValue = proceedMap.get(key).getOldValue();
                    result.append("    " + key + ": " + unchangedValue + "\n");
                    break;
                default:
                    throw new RuntimeException("operation not found");
            }
        }
        result.append("}");
        return result.toString();
    }
}
