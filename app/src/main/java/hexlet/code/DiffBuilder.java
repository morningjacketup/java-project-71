package hexlet.code;


import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Objects;

public class DiffBuilder {
    public static Map<String, Difference> build(final Map<String, Object> map1, final Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        Map<String, Difference> difference = new TreeMap<>();

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                difference.put(key, new Difference("added", map1.get(key), map2.get(key)));
            } else if (!map2.containsKey(key)) {
                difference.put(key, new Difference("deleted", map1.get(key), map2.get(key)));
            } else if (!(Objects.equals(map1.get(key), map2.get(key)))) {
                difference.put(key, new Difference("changed", map1.get(key), map2.get(key)));
            } else {
                difference.put(key, new Difference("unchanged", map1.get(key), map2.get(key)));
            }
        }
        return difference;
    }
}
