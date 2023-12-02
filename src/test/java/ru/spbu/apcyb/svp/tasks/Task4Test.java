package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Тесты для задания 4.
 */
class Task4Test {

  private static final Logger logger = Logger.getLogger(Task4Test.class.getName());

  @Test
  void singleThreadComputationTest() throws IOException {
    int numberOfLinesToRead = 5000;
    Path dataPath = Path.of("data.txt");
    Path resPath = Path.of("singleThreadTest.txt");

    try (FileWriter singleThreadComputationTest = new FileWriter("singleThreadTest.txt")) {
      Task4.singleThreadComputation(singleThreadComputationTest, "data.txt", numberOfLinesToRead);
    }

    try (BufferedReader dataReader = new BufferedReader(new FileReader(dataPath.toFile())); BufferedReader resReader = new BufferedReader(new FileReader(resPath.toFile()))) {
      String dataLine;
      String res;
      boolean result = true;
      for (int i = 0; i < numberOfLinesToRead; i++) {
        res = resReader.readLine();
        dataLine = dataReader.readLine();
        dataLine = String.valueOf(Math.tan(Double.parseDouble(dataLine)));
        if (!res.contains(dataLine)) {
          result = false;
          logger.info("В итоговом файле в " + i + " строке было найдено значение " + res + " вместо " + dataLine);
        }
        assertTrue(result);
      }
    }
  }

  @Test
  void multiThreadComputationTest() throws IOException, InterruptedException, ExecutionException {
    String multiThreadFileWriterName = "multiThreadTestRes.txt";
    int numberOfLinesToRead = 5000;
    int numberOfThreads = 10;
    Path filePath1 = Path.of("singleThreadTest.txt");
    Path filePath2 = Path.of("multiThreadTestRes.txt");
    String resultLine;
    String[] answer = new String[numberOfLinesToRead];
    String answerLine;

    int numbersInAnswer = 0;
    try (BufferedReader singleThreadResTestReader = new BufferedReader(new FileReader(filePath1.toFile()))) {

      while ((answerLine = singleThreadResTestReader.readLine()) != null) {
        answer[numbersInAnswer] = answerLine;
        numbersInAnswer++;
      }
    }

    Task4.multiThreadComputation(multiThreadFileWriterName, "data.txt", numberOfThreads);
    int viewedNumbers = 0;
    try (BufferedReader multiThreadResTestReader = new BufferedReader(new FileReader(filePath2.toFile()))) {
      while ((resultLine = multiThreadResTestReader.readLine()) != null) {
        boolean containsAnswer = false;
        for (var line : answer) {
          if (line.contains(resultLine)) {
            containsAnswer = true;
            break;
          }
        }
        if (!containsAnswer) {
          logger.info("Ошибка! Не было найдено в ответе значения " + resultLine);
        }
        assertTrue(containsAnswer);
        viewedNumbers++;
      }
    }
    assertEquals(numbersInAnswer, viewedNumbers);
  }

  @Test
  void fileNotFoundTest() throws IOException {
    try (FileWriter fileWriter = new FileWriter("someFile", false)) {
      assertThrows(FileNotFoundException.class, () -> Task4.singleThreadComputation(fileWriter, "wrongData", 1000));
    }
  }
}
