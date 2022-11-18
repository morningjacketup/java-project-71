package hexlet.code;

import picocli.CommandLine;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;


@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Compares two configuration files and shows a difference.");
        return 0;
    }
}
