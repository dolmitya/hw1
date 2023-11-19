package edu.hw6.task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;

    public static final AbstractFilter READABLE = Files::isReadable;

    private Filter() {
    }

    public static AbstractFilter largerThan(long expectedSize) {
        return (entry) -> Files.size(entry) > expectedSize;
    }

    public static AbstractFilter globMatches(String pattern) {
        return (entry) -> entry.toString().matches(pattern);
    }

    public static AbstractFilter magicNumber(char... chars) {
        final int countChars = chars.length;
        return (entry) -> {
            char[] charsFromFile = new char[countChars];

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(entry.toFile()))) {
                bufferedReader.read(charsFromFile, 0, countChars);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return Arrays.equals(chars, charsFromFile);
        };
    }

    public static AbstractFilter regexContains(String patternStr) {
        return (entry) -> {
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(entry.getFileName().toString());
            return matcher.find();
        };
    }
}
