package ru.spbu.apcyb.svp.tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задание 5.
 */
public class Task5 {

  static class MyException extends RuntimeException {

    public MyException(String message) {
      super(message);
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      throw new ArrayIndexOutOfBoundsException("Requires 2 arguments!");
    }
    String dataFile = args[0];
    String answerFile = args[1];
    try {
      List<String> lines = readFile(dataFile);
      Map<String, Long> wordCount = processLines(lines);
      writeFile(answerFile, wordCount);
    } catch (IOException e) {
      throw new MyException("IOException occurred");
    }
  }

  public static List<String> readFile(String dataFile) throws IOException {
    try (Stream<String> reader = Files.lines(Paths.get(dataFile))) {
      return reader.toList();
    } catch (IOException e) {
      throw new FileNotFoundException("Error occurred reading file: " + dataFile);
    }
  }

  public static Map<String, Long> processLines(List<String> lines) {
    return lines.stream()
        .flatMap(line -> Arrays.stream(line.trim().split(" ")))
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static void writeFile(String answerFile, Map<String, Long> wordCount) throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(answerFile))) {
      for (Map.Entry<String, Long> entry : wordCount.entrySet()) {
        String word = entry.getKey();
        long wordNumber = entry.getValue();
        String line = word + "=" + wordNumber;
        writer.write(line);
        writer.newLine();
        CompletableFuture.runAsync(() -> {
          try {
            writeWordToFile(word, wordNumber);
          } catch (IOException e) {
            throw new MyException("IOException occurred");
          }
        });
      }
    }
  }

  public static void writeWordToFile(String word, long wordNumber) throws IOException {
    if (Files.exists(Path.of(word + ".txt"))) {
      writeWordToExistingFile(word, wordNumber);
    } else {
      writeWordToNonExistingFile(word, wordNumber);
    }
  }

  public static void writeWordToNonExistingFile(String word, long wordNumber) throws FileNotFoundException {
    try (FileWriter wordFile = new FileWriter(word + ".txt", true)) {
      writeWordToExistingFile(word, wordNumber);
    } catch (IOException ex) {
      throw new FileNotFoundException("Error occurred while creating/reading file for a new word: " + word);
    }
  }

  public static void writeWordToExistingFile(String word, long wordNum) throws IOException {
    try (BufferedWriter wordFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((word + ".txt"))))) {
      for (int i = 0; i < wordNum; i++) {
        wordFile.write(word + "\n");
      }
    } catch (IOException e) {
      throw new FileNotFoundException("Error occurred writing a word: " + word);
    }
  }
}
