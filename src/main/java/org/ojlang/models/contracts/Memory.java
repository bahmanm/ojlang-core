package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * Memory space.
 * The granularity of memory cells is JVM object in contrast to normal Forth
 * systems whose cells are just bytes.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Memory extends Serializable {

  /**
   * Retrieves the current size of the memory.
   *
   * @return the current size of the memory
   */
  int size();

  /**
   * Retries a cell (i.e. JVM object) by its address.
   *
   * @param addr memory address
   * @return the object at the given address; should throw a runtime exception
   *  if the address is invalid.
   */
  Object get(int addr);

  /**
   * Adds an object to the memory (e.g. append)
   *
   * @param obj the given object
   * @return the modified memory
   */
  Memory add(Object obj);

  /**
   * Puts an object at a given address overriding its previous contents.
   *
   * @param obj the input object
   * @param addr the input memory address
   * @return the modified memory
   */
  Memory put(Object obj, int addr);

}
