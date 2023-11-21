package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import ru.spbu.apcyb.svp.tasks.Task5.MyException;


/**
 * Тесты для задания 5.
 */
class Task5Test {

  @Test
  void writeWordsToNonExistingFile() throws IOException {
    boolean fileDidNotExist = false;
    boolean fileExists = false;
    boolean check = false;
    Path path = Path.of("ne" + ".txt");
    if (!Files.exists(path)) {
      Task5.writeWordToNonExistingFile("ne", 1);
      fileDidNotExist = true;
    }
    if (Files.exists(path)) {
      fileExists = true;
    }
    if ((fileExists) && (fileDidNotExist)) {
      check = true;
    }
    assertTrue(check);
    Files.delete(path);
  }

  @Test
  void writeWordsToExistingFile() throws IOException {
    Task5.writeWordToExistingFile("футбол", 1);
    Path filePath = Path.of("футбол.txt");
    try (BufferedReader fromUnderdog = new BufferedReader(new FileReader(filePath.toFile()))) {
      String currentLine = fromUnderdog.readLine();
      assertEquals("футбол", currentLine);
    } catch (IOException ex) {
      throw new MyException("IOException occurred");
    }
  }

  @Test
  void countTest() throws IOException {
    int count = 0;
    Task5.countWords("datafileTest.txt", "countsTest.txt");
    String[] words = {"я", "играю", "в", "баскетбол"};
    for (String current : words) {
      Path path = Path.of(current + ".txt");
      if (Files.exists(path)) {
        count++;
        Files.delete(path);
      }
    }
    assertEquals(4, count);
  }

  @Test
  void countWordsTest() {
    int numberOfRightLines = 0;
    Path filePath = Path.of("countsTest.txt");
    String[] words = {"в=1", "баскетбол=1", "играю=1", "я=1"};
    try (BufferedReader fromCountsTestFile = new BufferedReader(new FileReader(filePath.toFile()))) {
      String currentLine;
      for (int i = 0; i < 4; i++) {
        currentLine = fromCountsTestFile.readLine();
        if (currentLine.equals(words[i])) {
          numberOfRightLines++;
        }
      }
      assertEquals(4, numberOfRightLines);
    } catch (IOException ex) {
      throw new MyException("IOException occurred");
    }
  }
}