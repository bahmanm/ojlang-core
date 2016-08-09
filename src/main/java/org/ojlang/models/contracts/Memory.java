package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Memory extends Serializable {

  int size();

  Object get(int addr);

  Memory clear();

  Memory add(Object obj);

  Memory put(Object obj, int addr);

}
