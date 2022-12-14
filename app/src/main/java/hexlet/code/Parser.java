package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static Map<String, Object> parse(String fileType, String fileContent) throws Exception {
        if (Objects.equals(fileType, "json")) {
            return jsonToMap(fileContent);
        } else if (Objects.equals(fileType, "yml")) {
            return yamlToMap(fileContent);
        } else {
            throw new Exception("File type '" + fileType + "' is not supported. Please, select .json or .yml file");
        }
    }

    private static Map<String, Object> jsonToMap(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(json, new TypeReference<>() {
        });
        return map;
    }

    private static Map<String, Object> yamlToMap(String yaml) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> map = mapper.readValue(yaml, new TypeReference<>() {
        });
        return map;
    }
}
