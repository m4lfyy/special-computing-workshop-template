package ru.spbu.apcyb.svp.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


@SuppressWarnings("checkstyle:MissingJavadocType")
public class Task1 {

  private static final Logger logger = Logger.getLogger(Task1.class.getName());
  private final ArrayList<String> combinations = new ArrayList<>();

  /**
   * Метод для получения числа комбинаций купюр данной суммы.
   *
   * @param sum - переменная для передачи суммы.
   * @param prevNom - переменная для хранения предыдущего номинала
   * @param combination - строка для хранения и вывода комбинации
   * @param nomArr - массив номиналов
   * @return число комбинаций
   */
  public int getCombinations(int sum, int prevNom, String combination, Integer [] nomArr) {
    int count = 0;
    if (sum == 0) {
      count++;
      logger.info(combination);
      combinations.add(combination);
    }
    for (int curNom : nomArr) {
      if ((prevNom >= curNom) && (sum >= curNom)) {
        count += getCombinations(sum - curNom, curNom,
            combination + " " + curNom + " ", nomArr);
      }
    }
    return count;
  }

  /**
   * Метод для парсинга суммы.
   *
   * @param str - строка с введенной суммой
   * @return сумма
   */

  public int parseSum(String str) {
    return parseToInteger(str);
  }

  /**
   * Метод для парсинга номиналов.
   *
   * @param str - строка с номиналами
   * @return отсортированный массив номиналов
   */


  public Integer [] parseNominal(String str) {
    if (str.isEmpty()) {
      throw new IllegalArgumentException("Error! Empty string!");
    }
    String[] strMas = str.split(" ");
    Integer [] nomArr = new Integer[strMas.length];
    for (int i = 0; i < nomArr.length; i++) {
      nomArr[i] = parseToInteger(strMas[i]);
    }
    return Arrays.stream(nomArr)
        .sorted(Comparator.reverseOrder())
        .distinct()
        .toArray(Integer[]::new);
  }

  /**
   * Метод для парсинга из String в Integer.
   *
   * @param str - число в типе String
   * @return число типа Integer
   */
  @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:RightCurly"})
  public int parseToInteger(String str) {
    int value;
    boolean flag = false;
    try {
      value = Integer.parseInt(str);
      if (value <= 0) {
        flag = true;
        throw new ArithmeticException("Error!");
      }
    }
    catch (Exception exp) {
      if (flag) {
        throw new ArithmeticException("Error! Value <= 0");
      } else {
        throw new IllegalArgumentException("Error! Value is not integer");
      }
    }
    return value;
  }

  @SuppressWarnings({"checkstyle:OverloadMethodsDeclarationOrder",
      "checkstyle:MissingJavadocMethod"})
  public List<String> getCombinations() {
    ArrayList<String> answer = new ArrayList<>(combinations);
    combinations.clear();
    return answer;
  }


  /**
   * Программа принимает от пользователя две строки из консоли.
   * sum - сумма,
   * nominal - номиналы через пробел.
   * Выводит комбинации и их число.
   */

  public static void main(String[] args) {
    Task1 obj = new Task1();
    Logger logger = Logger.getLogger(obj.getClass().getName());
    Scanner sc = new Scanner(System.in);
    String sum = sc.nextLine();
    String nominal = sc.nextLine();
    String str = String.valueOf(obj.getCombinations(obj.parseSum(sum), obj.parseNominal(nominal)[0],
        " ", obj.parseNominal(nominal)));
    logger.info(str);
  }
}

