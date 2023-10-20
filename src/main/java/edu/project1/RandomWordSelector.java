package edu.project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("RegexpSinglelineJava")
public class RandomWordSelector {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private String[] words = new String[0];

    public RandomWordSelector() {
        scanWordsFromFile();
    }

    private void scanWordsFromFile() {
        StringBuilder strbuild = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(
            "src\\main\\java\\edu\\project1\\words.txt"))) {
            br.lines().forEach(strbuild::append);
        } catch (FileNotFoundException e) {
            System.out.print("\nFile not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String wordsSeparate = strbuild.toString();
        words = wordsSeparate.split(", ");
    }

    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
