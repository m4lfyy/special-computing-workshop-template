package ru.spbu.apcyb.svp.tasks;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация очереди с имплементацией интерфейса java.util.Queue.
 */
public class OrdinaryQueue implements java.util.Queue<Object> {

  LinkedList list = new LinkedList();


  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }


  @Override
  public Object[] toArray() {
    return list.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод toArray(T[]) не переопределён");
  }

  @Override
  public boolean offer(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод offer не переопределён");
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
  public boolean add(Object o) throws IllegalStateException {
    list.add(o);
    return true;
  }

  @Override
  public Object remove() throws NoSuchElementException {
    if (list.isEmpty()) {
      throw new NoSuchElementException();
    }
    return list.remove(0);
  }

  @Override
  public boolean remove(Object o)  {
    return list.remove(o);
  }

  @Override
  public Object peek() {
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }


  @Override
  public Object poll() {
    if (list.isEmpty()) {
      return null;
    }
    return list.remove(0);
  }

  @Override
  public Object element() throws NoSuchElementException {
    if (list.isEmpty()) {
      throw new NoSuchElementException();
    }
    return list.get(0);
  }


  @Override
  public boolean addAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод addAll не переопределён");
  }

  @Override
  public void clear()throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод clear не переопределён");
  }

  @Override
  public boolean retainAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод retainAll не переопределён");
  }

  @Override
  public boolean removeAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод removeAll не переопределён");
  }

  @Override
  public boolean containsAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Метод containsAll не переопределён");
  }
}
