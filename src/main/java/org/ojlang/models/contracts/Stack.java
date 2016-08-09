package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * Stack data structure.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Stack<T> extends Serializable {

  /**
   * Pops the top of the stack.
   *
   * @return the top of the stack; should throw a runtime exception if it's
   *  empty.
   */
  T pop();

  /**
   * Returns the size of the stack.
   *
   * @return the size of the stack.
   */
  int size();

  /**
   * Empties the stack.
   *
   * @return the modified stack
   */
  Stack clear();

  /**
   * Pushes an object on the top of the stack.
   *
   * @param arg the input object
   * @return the modified stack
   */
  Stack push(T arg);

  /**
   * Peeks at the contents of the stack at a given index.
   * The index value should be a reverse index.  For example if the stack
   * contains [a,b,c,d] (with the top being on the left), to peek at 'c' one
   * should use the index 1.
   *
   * @param index the index (starting from the top of stack as 0)
   * @return the object at the index; should throw a runtime exception if index
   * is out of range.
   */
  T peek(int index);

  /**
   * Peeks at the top of the stack (without popping).
   *
   * @return the object at the top; should throw a runtime exception if stack is
   *  empty.
   */
  T peek();

}
