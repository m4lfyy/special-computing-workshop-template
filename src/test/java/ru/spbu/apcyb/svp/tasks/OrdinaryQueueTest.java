package ru.spbu.apcyb.svp.tasks;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdinaryQueueTest {


  @Test
  @DisplayName("addTest1")
  void addTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("string");
    Assertions.assertEquals("string", ordinaryQueue.peek());
  }

  @Test
  @DisplayName("sizeTest1")
  void sizeTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertEquals(0, ordinaryQueue.size());
  }

  @Test
  @DisplayName("sizeTest2")
  void sizeTest2() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add(5);
    Assertions.assertEquals(1, ordinaryQueue.size());
  }

  @Test
  @DisplayName("pollTest1")
  void pollTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("string");
    ordinaryQueue.add(5);
    Object element = ordinaryQueue.poll();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{5}, ordinaryQueue.toArray())
    );
  }

  @Test
  @DisplayName("pollTest2")
  void pollTest2() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertNull(ordinaryQueue.poll());
  }

  @Test
  @DisplayName("elementTest1")
  void elementTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("string");
    ordinaryQueue.add(5);
    Object element = ordinaryQueue.element();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{"string", 5}, ordinaryQueue.toArray())
    );
  }

  @Test
  @DisplayName("elementExceptionTest")
  void elementExceptionTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(NoSuchElementException.class, ordinaryQueue::element);
  }

  @Test
  @DisplayName("removeTest1")
  void removeTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("string");
    ordinaryQueue.add(5);
    Object element = ordinaryQueue.remove();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{5}, ordinaryQueue.toArray())
    );
  }

  @Test
  @DisplayName("removeExceptionTest")
  void removeExceptionTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(NoSuchElementException.class, ordinaryQueue::remove);
  }

  @Test
  @DisplayName("removeTest2")
  void removeTest2() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("a");
    ordinaryQueue.add("b");
    ordinaryQueue.remove("b");
    assertArrayEquals(new Object[]{"a"}, ordinaryQueue.toArray());
  }

  @Test
  @DisplayName("peekTest1")
  void peekTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("string");
    ordinaryQueue.add(5);
    Object element = ordinaryQueue.peek();
    assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{"string", 5}, ordinaryQueue.toArray())
    );
  }

  @Test
  @DisplayName("peekTest2")
  void peekTest2() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertNull(ordinaryQueue.peek());
  }

  @Test
  @DisplayName("isEmptyTest1")
  void isEmptyTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    assertTrue(ordinaryQueue.isEmpty());
  }

  @Test
  @DisplayName("isEmptyTest2")
  void isEmptyTest2() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add(5);
    assertFalse(ordinaryQueue.isEmpty());
  }

  @Test
  @DisplayName("clearTest1")
  void clearTest1() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add(new Integer[]{3, 6, 5});
    ordinaryQueue.clear();
    assertTrue(ordinaryQueue.isEmpty());
  }
}