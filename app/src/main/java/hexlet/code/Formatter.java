package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.Map;

public class Formatter {
    public static String getFormat(String formatName,
                                   Map<String, String> proceedMap,
                                   Map<String, Object> map1,
                                   Map<String, Object> map2) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.format(proceedMap, map1, map2);
            case "plain":
                return Plain.format(proceedMap, map1, map2);
            case "json":
                return Json.format(proceedMap);
            default:
                throw new Exception("format is not supported");
        }
    }
}
