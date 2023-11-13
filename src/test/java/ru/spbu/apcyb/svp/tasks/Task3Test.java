package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;


class Task3Test {

  @Test
  void notExistingDirectoryException() {
    String[] args = {"NotExistingDirectory", "answer.txt"};
    assertThrows(FileNotFoundException.class, () -> Task3.main(args));
  }

  @Test
  void directoryException() {
    String[] args = {"..//", "..//"};
    assertThrows(NotDirectoryException.class, () -> Task3.main(args));
  }

  @Test
  void invalidInputException() {
    String[] args = {"..//"};
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task3.main(args));
  }

  @Test
  void getListFiles() throws IOException {
    String filepath = "src/test/resources/";
    String[] args = {filepath, "result.txt"};
    Task3.main(args);
    boolean equals = true;
    try (BufferedReader resReader = new BufferedReader(new FileReader(Path.of("result.txt").toFile())); BufferedReader ansReader = new BufferedReader(new FileReader(Path.of("answer.txt").toFile()))) {
      String resLine = resReader.readLine();
      String ansLine = ansReader.readLine();
      while (resLine != null && ansLine != null) {
        if (!ansLine.equals(resLine)) {
          equals = false;
        }
        resLine = resReader.readLine();
        ansLine = ansReader.readLine();
      }
      if (resLine != null || ansLine != null) {
        equals = false;
      }
    }
    assertTrue(equals);
  }

  @Test
  void fileFounderTest() {
    String[] args = {"..//", "example.txt"};
    assertDoesNotThrow(() -> Task3.main(args));
  }
}