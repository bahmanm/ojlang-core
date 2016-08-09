package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Word extends Serializable {

  int popAddr();

  int peekAddr();

  Word pushAddr(int addr);

  String name();

  default boolean isSystemWord() {
    return false;
  }

}
