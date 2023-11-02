package ru.spbu.apcyb.svp.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Реализация двусвязного списка с имплементацией интерфейса java.util.List.
 */
public class LinkedList implements java.util.List<Object> {

  private int size = 0;
  private Node head = null;

  /**
   * Узлы двусвязного списка.
   */
  public static class Node {


    private final Object data;
    private Node right;
    private Node left;

    Node(Object data, Node left, Node right) {
      this.data = data;
      this.right = right;
      this.left = left;
    }
  }


  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public boolean contains(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод contains не переопределён");
  }

  @Override
  public Iterator<Object> iterator() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод iterator не переопределён");
  }

  @Override
  public Object[] toArray() {
    Object[] result = new Object[this.size()];
    Node current = head;
    for (int i = 0; i < this.size(); i++) {
      result[i] = current.data;
      current = current.right;
    }
    return result;
  }

  @Override
  public <T> T[] toArray(T[] a) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод toArray(T[]) не переопределён");
  }

  @Override
  public boolean add(Object o) {
    Node current = head;
    if (head == null) {
      head = new Node(o, null, null);
    } else {
      while (current.right != null) {
        current = current.right;
      }
      current.right = new Node(o, current, null);
    }
    size++;
    return true;
  }

  @Override
  public void add(int index, Object element) throws IndexOutOfBoundsException {
    Node current = head;
    if (index < 0 || index > this.size()) {
      throw new IndexOutOfBoundsException();
    }

    int curIndex = 0;
    while (curIndex != index) {
      current = current.right;
      curIndex++;
    }

    if (current == null) {
      head = new Node(element, null, null);
    } else if (current.left == null) {
      Node newNode = new Node(element, null, current);
      head.left = newNode;
      head = newNode;
    } else {
      Node newNode = new Node(element, current.left, current);
      newNode.left.right = newNode;
      current.left = newNode;
    }
    size++;
  }

  @Override
  public boolean remove(Object o) {
    Node it = head;
    while (it != null && it.data != o) {
      it = it.right;
    }
    if (it != null) {

      if (it.left == null) {
        head = it.right;
      } else {
        it.left.right = it.right;
      }

      if (it.right != null) {
        it.right.left = it.left;
      }
      size--;
      return true;
    }
    return false;
  }

  @Override
  public Object remove(int index) throws IndexOutOfBoundsException {
    Node current = head;
    if (index < 0 || index >= this.size()) {
      throw new IndexOutOfBoundsException();
    }
    int curIndex = 0;
    while (curIndex != index) {
      current = current.right;
      curIndex++;
    }
    if (current.left == null) {
      head = current.right;
    } else {
      current.left.right = current.right;
    }
    if (current.right != null) {
      current.right.left = current.left;
    }
    size--;
    return current.data;
  }

  @Override
  public boolean containsAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод containsAll не переопределён");
  }

  @Override
  public boolean addAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод addAll не переопределён");
  }

  @Override
  public boolean addAll(int index, Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод addAll не переопределён");
  }

  @Override
  public boolean removeAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод removeAll не переопределён");
  }

  @Override
  public boolean retainAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод retainAll не переопределён");
  }

  @Override
  public void clear() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод clear не переопределён");
  }

  @Override
  public Object get(int index) throws IndexOutOfBoundsException {
    Node current = head;
    if (index >= this.size() || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    int curIndex = 0;
    while (curIndex != index) {
      current = current.right;
      curIndex++;
    }
    return current.data;
  }

  @Override
  public Object set(int index, Object element) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод set не переопределён");
  }

  @Override
  public int indexOf(Object o) {

    Node current = this.head;
    int index = 0;
    while (current != null && current.data != o) {
      current = current.right;
      index++;
    }
    if (current != null) {
      return index;
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод lastIndexOf не переопределён");
  }

  @Override
  public ListIterator<Object> listIterator() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод listIterator не переопределён");
  }

  @Override
  public ListIterator<Object> listIterator(int index) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод listIterator не переопределён");
  }

  @Override
  public List<Object> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод subList не переопределён");
  }
}
