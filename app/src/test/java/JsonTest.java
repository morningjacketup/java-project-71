import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    @Test
    void test1() throws Exception {
        String json = "{\"age\":\"changed\",\"full name\":\"unchanged\",\"isAlive\":\"unchanged\",\"sex\":\"changed\"}";
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }

    @Test
    void test2() throws Exception {
        String json = "{\"age\":\"changed\",\"full name\":\"unchanged\",\"isAlive\":\"unchanged\",\"sex\":\"changed\"}";
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }

    @Test
    void test3() throws Exception {
        String json = "{}";
        String path = "src/test/resources/emptyjson.json";
        String path2 = "src/test/resources/emptyjson2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }

    @Test
    void test4() throws Exception {
        String json = "{\"address\":\"unchanged\",\"description\":\"unchanged\",\"email\":\"unchanged\","
                + "\"name\":\"unchanged\",\"phone\":\"unchanged\"}";
        String path = "src/test/resources/sameValuesYML.yml";
        String path2 = "src/test/resources/sameValuesYML2.yml";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }
}
