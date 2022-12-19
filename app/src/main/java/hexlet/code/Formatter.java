package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.Map;

public class Formatter {
    public static String getFormat(String formatName,
                                   Map<String, Difference> proceedMap) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.format(proceedMap);
            case "plain":
                return Plain.format(proceedMap);
            case "json":
                return Json.format(proceedMap);
            default:
                throw new Exception(formatName + " format is not supported");
        }
    }
}
