package ru.spbu.apcyb.svp.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Реализация двусвязного списка с имплементацией интерфейса java.util.List.
 */
public class LinkedList implements java.util.List<Object> {


  private Node head = null;

  @SuppressWarnings("checkstyle:MissingJavadocType")
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
    int it = 0;
    Node element = head;
    while (element != null) {
      it++;
      element = element.right;
    }
    return it;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public boolean contains(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<Object> iterator() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public Object[] toArray() throws UnsupportedOperationException {
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
    throw new UnsupportedOperationException();
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
    }
    return true;
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
    return current.data;
  }

  @Override
  public boolean containsAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean addAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean addAll(int index, Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean removeAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean retainAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void clear() {
    head = null;
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
    throw new UnsupportedOperationException();
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
    throw new UnsupportedOperationException();
  }

  @Override
  public ListIterator<Object> listIterator() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public ListIterator<Object> listIterator(int index) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Object> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }
}
