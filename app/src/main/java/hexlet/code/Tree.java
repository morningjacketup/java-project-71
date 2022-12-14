package hexlet.code;


import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tree {
    public static Map<String, String> build(final Map<String, Object> map1, final Map<String, Object> map2) {
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
