package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LinkedListTest {

  @Test
  void addObjectTest() {
    LinkedList list = new LinkedList();
    list.add(5);
    Assertions.assertArrayEquals(new Integer[]{5}, list.toArray());
  }

  @Test
  void addSeveralObjectsTest() {
    LinkedList list = new LinkedList();
    list.add(0, 5);
    list.add(0, "string");
    list.add(1, 7);
    Assertions.assertArrayEquals(new Object[]{"string", 7, 5}, list.toArray());
  }

  @Test
  void addExceptionTest() {
    LinkedList list = new LinkedList();
    list.add("string");
    assertThrows(IndexOutOfBoundsException.class,
        () -> list.add(3, 6));
  }


  @Test
  void sizeEmptyTest() {
    LinkedList list = new LinkedList();
    Assertions.assertEquals(0, list.size());
  }

  @Test
  void multipleSizeTest() {
    LinkedList list = new LinkedList();
    list.add("string");
    list.add(0, "temp");
    list.remove("string");
    Assertions.assertEquals(1, list.size());
  }

  @Test
  void emptyListTest() {
    LinkedList list = new LinkedList();
    Assertions.assertTrue(list.isEmpty());
  }

  @Test
  void notEmptyListTest() {
    LinkedList list = new LinkedList();
    list.add(new int[]{1});
    Assertions.assertFalse(list.isEmpty());
  }

  @Test
  void removeObjectTest() {
    LinkedList list = new LinkedList();
    list.add(10);
    list.add(5);
    list.add(1);
    list.remove(Integer.valueOf(5));
    Assertions.assertArrayEquals(new Object[]{10, 1}, list.toArray());
  }

  @Test
  void removeIndexTest() {
    LinkedList list = new LinkedList();
    list.add(5);
    Object element = list.remove(0);

    assertAll(
        () -> Assertions.assertTrue(list.isEmpty()),
        () -> Assertions.assertEquals("5", element.toString())
    );
  }


  @Test
  void removeSeveralTest() {
    LinkedList list = new LinkedList();
    list.add(5);
    list.add("string");
    list.remove(0);
    Assertions.assertEquals("string", list.get(0));
  }

  @Test
  void removeFromEmptyListTest() {
    LinkedList list = new LinkedList();
    assertThrows(IndexOutOfBoundsException.class,
        () -> list.remove(0));
  }

  @Test
  void removeFalseTest() {
    LinkedList list = new LinkedList();
    list.add("string");
    Assertions.assertFalse(list.remove("temp"));
  }

  @Test
  void getTest() {
    LinkedList list = new LinkedList();
    list.add(5);
    list.add("string");
    list.add(new int[]{3});
    Assertions.assertEquals("string", list.get(1));
  }

  @Test
  void getExceptionTest() {
    LinkedList list = new LinkedList();
    list.add(5);
    assertThrows(IndexOutOfBoundsException.class,
        () -> list.get(2));
  }

  @Test
  void indexOfTrueTest() {
    LinkedList list = new LinkedList();
    list.add("string");
    Assertions.assertEquals(0, list.indexOf("string"));
  }

  @Test
  void indexOfFalseTest2() {
    LinkedList list = new LinkedList();
    list.add("string");
    Assertions.assertEquals(-1, list.indexOf(10));
  }

  @Test
  void clearExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, list::clear);
  }

  @Test
  void containsExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, () -> list.contains(0));
  }

  @Test
  void iteratorExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, list::iterator);
  }

  @Test
  void setExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, () -> list.set(0, 5));
  }

  @Test
  void lastIndexOfExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, () -> list.lastIndexOf(0));
  }

  @Test
  void listIteratorExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, list::listIterator);
  }

  @Test
  void sublistExceptionTest() {
    LinkedList list = new LinkedList();
    assertThrows(UnsupportedOperationException.class, () -> list.subList(0, 2));
  }
}