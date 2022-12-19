import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    @Test
    void test1() throws Exception {
        String json = "{\"age\":{\"status\":\"changed\",\"oldValue\":60,\"newValue\":50},\"full name\":{\""
                + "status\":\"unchanged\",\"oldValue\":\"Michael Jordan\",\"newValue\":\"Michael Jordan\"},\""
                + "isAlive\":{\"status\":\"unchanged\",\"oldValue\":true,\"newValue\":true},\"sex\":{\"status\""
                + ":\"changed\",\"oldValue\":\"Male\",\"newValue\":\"Female\"}}";
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }

    @Test
    void test2() throws Exception {
        String json = "{}";
        String path = "src/test/resources/emptyjson.json";
        String path2 = "src/test/resources/emptyjson2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }

    @Test
    void test3() throws Exception {
        String json = "{\"address\":{\"status\":\"unchanged\",\"oldValue\":{\"streetName\":\"Ratke Road\","
                + "\"streetAddress\":\"88602 Nolan Manors Suite 836\",\"city\":\"Klockoborough\",\"postcode\":"
                + "\"82373\",\"country\":\"Cocos (Keeling) Islands\"},\"newValue\":{\"streetName\":\"Ratke Road\""
                + ",\"streetAddress\":\"88602 Nolan Manors Suite 836\",\"city\":\"Klockoborough\",\"postcode\":"
                + "\"82373\",\"country\":\"Cocos (Keeling) Islands\"}},\"description\":{\"status\":\"unchanged\""
                + ",\"oldValue\":\"Dignissimos deleniti cum suscipit qui. Eveniet facere nisi est error culpa atque."
                + " Unde officiis hic rerum.\",\"newValue\":\"Dignissimos deleniti cum suscipit qui. "
                + "Eveniet facere nisi est error culpa atque. Unde officiis hic rerum.\"},\"email\":{\"status\""
                + ":\"unchanged\",\"oldValue\":\"name53@padberg.org\",\"newValue\":\"name53@padberg.org\"},"
                + "\"name\":{\"status\":\"unchanged\",\"oldValue\":\"Concepcion Pollich\",\"newValue\":"
                + "\"Concepcion Pollich\"},\"phone\":{\"status\":\"unchanged\",\"oldValue\":\""
                + "+1-575-403-3225\",\"newValue\":\"+1-575-403-3225\"}}";
        String path = "src/test/resources/sameValuesYML.yml";
        String path2 = "src/test/resources/sameValuesYML2.yml";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }


}
