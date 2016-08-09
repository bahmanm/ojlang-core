package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * A word; the fundamental piece of code in Oj.
 *
 * A word basically consists of a name and series of memory addresses. Each
 * memory address, denoting a version of thw world, points to the beginning of
 * its definition in memory.
 *
 * @see Memory
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Word extends Serializable {

  /**
   * Retrieves AND removes the most recent address of the word definition.
   *
   * @return the (starting) memory address of the most recent definition.
   */
  int popAddr();

  /**
   * Peeks at the most recent address of the word definition.
   *
   * @return the (starting) memory address of the most recent definition.
   */
  int peekAddr();

  /**
   * Pushes a new memory address (i.e. a new definition of the word).
   *
   * @param addr the given address
   * @return the modified word
   */
  Word pushAddr(int addr);

  /**
   * Returns the name of the word.
   *
   * @return the name of the word
   */
  String name();

  /**
   * Checks if the word is a system word.
   *
   * @return true if this is a system word
   */
  default boolean isSystemWord() {
    return false;
  }

}
