package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LinkedListTest {

  @Test
  @DisplayName("addTest1")
  void addTest1() {
    LinkedList list = new LinkedList();
    list.add(5);
    Assertions.assertArrayEquals(new Integer[]{5}, list.toArray());
  }

  @Test
  @DisplayName("addTest2")
  void addTest2() {
    LinkedList list = new LinkedList();
    list.add(0, 5);
    list.add(0, "string");
    Assertions.assertArrayEquals(new Object[]{"string", 5}, list.toArray());
  }

  @Test
  @DisplayName("addTest3")
  void addTest3() {
    LinkedList list = new LinkedList();
    list.add(0, 5);
    list.add(0, "string");
    list.add(1, 7);
    Assertions.assertArrayEquals(new Object[]{"string", 7, 5}, list.toArray());
  }

  @Test
  @DisplayName("addExceptionTest")
  void addExceptionTest() {
    LinkedList list = new LinkedList();
    list.add("string");
    assertThrows(IndexOutOfBoundsException.class,
        () -> list.add(3, 6));
  }


  @Test
  @DisplayName("sizeTest1")
  void sizeTest1() {
    LinkedList list = new LinkedList();
    Assertions.assertEquals(0, list.size());
  }

  @Test
  @DisplayName("sizeTest2")
  void sizeTest2() {
    LinkedList list = new LinkedList();
    list.add("string");
    Assertions.assertEquals(1, list.size());
  }

  @Test
  @DisplayName("isEmptyTest1")
  void isEmptyTest1() {
    LinkedList list = new LinkedList();
    Assertions.assertTrue(list.isEmpty());
  }

  @Test
  @DisplayName("isEmptyTest2")
  void isEmptyTest2() {
    LinkedList list = new LinkedList();
    list.add(new int[]{1});
    Assertions.assertFalse(list.isEmpty());
  }

  @Test
  @DisplayName("removeTest1")
  void removeTest1() {
    LinkedList list = new LinkedList();
    list.add(10);
    list.add(5);
    list.add(1);
    list.remove(Integer.valueOf(5));
    Assertions.assertArrayEquals(new Object[]{10, 1}, list.toArray());
  }

  @Test
  @DisplayName("removeTest2")
  void removeTest2() {
    LinkedList list = new LinkedList();
    list.add("string");
    list.remove("string");
    Assertions.assertTrue(list.isEmpty());
  }


  @Test
  @DisplayName("removeTest3")
  void removeTest3() {
    LinkedList list = new LinkedList();
    list.add(5);
    Object element = list.remove(0);

    assertAll(
        () -> Assertions.assertTrue(list.isEmpty()),
        () -> Assertions.assertEquals("5", element.toString())
    );
  }


  @Test
  @DisplayName("removeTest4")
  void removeTest4() {
    LinkedList list = new LinkedList();
    list.add(5);
    list.add("string");
    list.remove(0);
    Assertions.assertEquals("string", list.get(0));

  }

  @Test
  @DisplayName("removeTest5")
  void removeTest5() {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.remove(2);
    Assertions.assertArrayEquals(new Object[]{1, 2}, list.toArray());

  }

  @Test
  @DisplayName("removeExceptionTest")
  void removeExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(IndexOutOfBoundsException.class,
        () -> list.remove(0));
  }


  @Test
  @DisplayName("getTest1")
  void getTest1() {
    LinkedList list = new LinkedList();
    list.add(5);
    list.add("string");
    list.add(new int[]{3});
    Assertions.assertEquals("string", list.get(1));
  }

  @Test
  @DisplayName("getExceptionTest")
  void getExceptionTest() {
    LinkedList list = new LinkedList();
    list.add(5);
    assertThrows(IndexOutOfBoundsException.class,
        () -> list.get(2));
  }


  @Test
  @DisplayName("indexOfTest1")
  void indexOfTest1() {

    LinkedList list = new LinkedList();
    list.add("string");
    Assertions.assertEquals(0, list.indexOf("string"));
  }

  @Test
  @DisplayName("indexOfTest2")
  void indexOfTest2() {
    LinkedList list = new LinkedList();
    list.add("string");
    Assertions.assertEquals(-1, list.indexOf(10));
  }

  @Test
  @DisplayName("clearTest1")
  void clearTest1() {
    LinkedList list = new LinkedList();
    list.add(new Integer[]{3, 6, 5});
    list.clear();
    assertTrue(list.isEmpty());
  }
}