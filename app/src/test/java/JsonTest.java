import hexlet.code.Differ;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    @Test
    void test1() throws Exception {
        String json = "{\"chars1\":\"unchanged\",\"chars2\":\"changed\",\"checked\":\"changed\",\"default\":\""
                + "changed\",\"id\":\"changed\",\"key1\":\"deleted\",\"key2\":\"added\",\"numbers1\":\"unchanged\","
                + "\"numbers2\":\"changed\",\"numbers3\":\"\n"
                + "deleted\",\"numbers4\":\"added\",\"obj1\":\"added\",\"setting1\":\"changed\",\"setting2\":\""
                + "changed\",\"setting3\":\"changed\"}";
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "json"));
    }
}
