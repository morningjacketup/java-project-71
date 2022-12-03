package hexlet.code;

import picocli.CommandLine;
import java.util.concurrent.Callable;


@CommandLine.Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Object> {

    @CommandLine.Option(names = { "-f", "--format" },
            paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(index = "1",paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Override
    public Integer call() throws Exception {
        String difference = Differ.generate(filePath1, filePath2);
        System.out.println(difference);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
