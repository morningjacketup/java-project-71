package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static Map<String, Object> parse(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + pathToFile + "' does not exists");
        }

        String readFile = Files.readString(path);
        String fileType = FilenameUtils.getExtension(pathToFile);

        if (Objects.equals(fileType, "json")) {
            return jsonToMap(readFile);
        } else if (Objects.equals(fileType, "yml")) {
            return yamlToMap(readFile);
        } else {
            throw new Exception("File type '" + fileType + "' is not supported. Please, select .json or .yml file");
        }
    }

    public static Map<String, Object> jsonToMap(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(json, new TypeReference<>() {
        });
        return map;
    }

    public static Map<String, Object> yamlToMap(String yaml) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> map = mapper.readValue(yaml, new TypeReference<>() {
        });
        return map;
    }
}
