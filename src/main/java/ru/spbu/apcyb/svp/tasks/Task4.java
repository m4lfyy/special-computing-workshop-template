package ru.spbu.apcyb.svp.tasks;

import java.io.*;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * Задание 4. Многопоточность.
 */
public class Task4 {
  private static final Logger logger = Logger.getLogger(Task4.class.getName());

  public static void generateNumbers(String filename, int count) throws IOException {
    try (var fileWriter = new FileWriter(filename)) {
      var random = new SecureRandom();
      for (int i = 0; i < count; i++) {
        fileWriter.write(random.nextDouble() + System.lineSeparator());
      }
      fileWriter.flush();
    }
  }

  public static void singleThreadComputation(FileWriter fileWriter, String inputFileName, int numberOfLines) throws IOException {
    long start = System.currentTimeMillis();
    Path filePath = Path.of(inputFileName);
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
      String currentLine;
      for (int i = 0; i < numberOfLines; i++) {
        currentLine = bufferedReader.readLine();
        double value = Math.tan(Double.parseDouble(currentLine));
        fileWriter.write(value + "\n");
      }
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File not found!");
    } catch (IOException e) {
      throw new IOException("IOException occurred!");
    }
    long finish = System.currentTimeMillis();
    long time = finish - start;
    String result = "Время вычисления 1 потока: " + time;
    logger.info(result);
  }

  public static void multiThreadComputation(String fileWriterName, String inputFileName, int numberOfThreads) throws IOException, InterruptedException, ExecutionException {
    long start = System.currentTimeMillis();
    ExecutorService executorService = null;
    List<Future<Double>> futures = new ArrayList<>();
    try {
      executorService = Executors.newFixedThreadPool(numberOfThreads);
      try (Scanner sc = new Scanner(new FileReader(inputFileName)).useLocale(Locale.US);
          FileWriter fileWriter = new FileWriter(fileWriterName)) {

        while (sc.hasNextDouble()) {
          double x = sc.nextDouble();
          futures.add(executorService.submit(() -> Math.tan(x)));
        }
        for (var future : futures) {
          fileWriter.write(future.get() + System.lineSeparator());
        }
      }
    } finally {
      if (executorService != null) {
        executorService.shutdown();
      }
    }
    long finish = System.currentTimeMillis();
    long time = finish - start;
    String result = "Время вычисления для " + numberOfThreads + " потоков: " + time;
    logger.info(result);
  }

  public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
    String inputFileName = "data.txt";
    generateNumbers(inputFileName, 10000);
    try (FileWriter singleThreadFileWriter = new FileWriter("singleThreadRes.txt", false)) {
      singleThreadComputation(singleThreadFileWriter, inputFileName, 10000);
    }
    String multiThreadFileWriterName = "multiThreadRes.txt";
    multiThreadComputation(multiThreadFileWriterName, inputFileName, 10);
  }
}
