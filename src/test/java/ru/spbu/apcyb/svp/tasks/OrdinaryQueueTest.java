package ru.spbu.apcyb.svp.tasks;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrdinaryQueueTest {


  @Test
  void addObjectTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("string");
    Assertions.assertEquals("string", ordinaryQueue.peek());
  }

  @Test
  void sizeEmptyTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertEquals(0, ordinaryQueue.size());
  }

  @Test
  void sizeSeveralTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add(5);
    ordinaryQueue.remove();
    Assertions.assertEquals(0, ordinaryQueue.size());
  }

  @Test
  void pollTest() {
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
  void pollNullTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertNull(ordinaryQueue.poll());
  }

  @Test
  void elementTest() {
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
  void elementExceptionTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(NoSuchElementException.class, ordinaryQueue::element);
  }

  @Test
  void removeTest() {
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
  void removeExceptionTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(NoSuchElementException.class, ordinaryQueue::remove);
  }

  @Test
  void removeSeveralTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add("a");
    ordinaryQueue.add("b");
    ordinaryQueue.remove("b");
    assertArrayEquals(new Object[]{"a"}, ordinaryQueue.toArray());
  }

  @Test
  void peekTest() {
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
  void peekNullTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertNull(ordinaryQueue.peek());
  }

  @Test
  void isEmptyTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    assertTrue(ordinaryQueue.isEmpty());
  }

  @Test
  void isEmptyFalseTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    ordinaryQueue.add(5);
    assertFalse(ordinaryQueue.isEmpty());
  }

  @Test
  void clearTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(UnsupportedOperationException.class, ordinaryQueue::clear);
  }

  @Test
  void offerTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> ordinaryQueue.offer(5));
  }

  @Test
  void iteratorTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(UnsupportedOperationException.class, ordinaryQueue::iterator);
  }

  @Test
  void containsTest() {
    OrdinaryQueue ordinaryQueue = new OrdinaryQueue();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> ordinaryQueue.contains(0));
  }
}