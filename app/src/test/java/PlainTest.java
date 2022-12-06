import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlainTest {
    @Test
    void test1() throws Exception {
        String json = "Property 'age' was updated. From 60 to 50\n"
                + "Property 'sex' was updated. From 'Male' to 'Female'";
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "plain"));
    }

    @Test
    void test2() throws Exception {
        String expected = "Property 'address' was updated. From [complex value] to [complex value]\n"
                + "Property 'description' was updated. From 'Delectus dolores nihil eos ipsam sed.' to "
                + "'Tenetur quos eos ex est expedita autem optio at.'\n"
                + "Property 'name' was updated. From 'Donna Windler' to 'Sibyl Shanahan'\n"
                + "Property 'phone' was updated. From '(947) 639-5392' to '386.498.7405'";
        String path = "src/test/resources/yaml1.yml";
        String path2 = "src/test/resources/yaml2.yml";
        assertThat(expected).isEqualTo(Differ.generate(path, path2, "plain"));
    }

    @Test
    void test3() throws Exception {
        String expected = "";
        String path = "src/test/resources/sameValuesYML2.yml";
        String path2 = "src/test/resources/sameValuesYML2.yml";
        assertThat(expected).isEqualTo(Differ.generate(path, path2, "plain"));
    }
}
