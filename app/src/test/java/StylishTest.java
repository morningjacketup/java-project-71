import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StylishTest {
    @Test
    void test1() throws Exception {
        String json = "{\n"
                + " - age: 60\n"
                + " + age: 50\n"
                + "   full name: Michael Jordan\n"
                + "   isAlive: true\n"
                + " - sex: Male\n"
                + " + sex: Female\n"
                + "}";
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        assertThat(json).isEqualTo(Differ.generate(path, path2, "stylish"));
    }

    @Test
    void test2() throws Exception {
        String expected = "{\n"
                + " - address: {streetName=Hettinger Forges, streetAddress=953 Hintz Valley, "
                + "city=Bergnaummouth, zipcode=70672-6518, country=Indonesia}\n"
                + " + address: {streetName=Hettinger Forges, streetAddress=3950 Vernon Dam Apt. 545, "
                + "city=North Cory, postcode=75013, country=Mozambique}\n"
                + " - description: Delectus dolores nihil eos ipsam sed.\n"
                + " + description: Tenetur quos eos ex est expedita autem optio at.\n"
                + "   email: imueller@lind.com\n"
                + " - name: Donna Windler\n"
                + " + name: Sibyl Shanahan\n"
                + " - phone: (947) 639-5392\n"
                + " + phone: 386.498.7405\n"
                + "}";
        String path = "src/test/resources/yaml1.yml";
        String path2 = "src/test/resources/yaml2.yml";
        assertThat(expected).isEqualTo(Differ.generate(path, path2, "stylish"));
    }

    @Test
    void test3() throws Exception {
        String path = "src/test/resources/file.xml";
        String path2 = "src/test/resources/yaml1.yml";
        Exception thrown = assertThrows(
                Exception.class,
                () -> Differ.generate(path, path2, "stylish"),
                "Expected doThing() to throw, but it didn't"
        );
        Assertions.assertEquals("File type 'xml' is not supported. Please, select .json or .yml file",
                thrown.getMessage());
    }

    @Test
    void test4() throws Exception {
        String expected = "{\n"
                + "   address: {streetName=Ratke Road, streetAddress=88602 Nolan Manors Suite 836, city=Klockoborough, "
                + "postcode=82373, country=Cocos (Keeling) Islands}\n"
                + "   description: Dignissimos deleniti cum suscipit qui. Eveniet facere nisi est error culpa atque. "
                + "Unde officiis hic rerum.\n"
                + "   email: name53@padberg.org\n"
                + "   name: Concepcion Pollich\n"
                + "   phone: +1-575-403-3225\n"
                + "}";
        String path = "src/test/resources/sameValuesYML.yml";
        String path2 = "src/test/resources/sameValuesYML2.yml";
        assertThat(expected).isEqualTo(Differ.generate(path, path2, "stylish"));
    }
}
