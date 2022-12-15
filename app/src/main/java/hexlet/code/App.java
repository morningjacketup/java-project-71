package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @CommandLine.Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filePath2;
    private static final int SUCCESS = 0;
    private static final int FAIL = 1;

    @Override
    public final Integer call() throws Exception {
        try {
            String difference = Differ.generate(filePath1, filePath2, format);
            System.out.println(difference);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return FAIL;
        }
        return SUCCESS;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
