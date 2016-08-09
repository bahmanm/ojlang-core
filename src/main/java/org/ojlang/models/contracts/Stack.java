package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Stack<T> extends Serializable {

  T pop();

  int size();

  Stack clear();

  Stack push(T arg);

  T peek(int index);

  T peek();

}
