package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * Oj dictionary; a mapping of names to words.
 *
 * @see Word
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Dictionary extends Serializable {

  /**
   * Retrieves a word by its name.
   *
   * @param name the input name
   * @return the word; should throw a runtime exception if no such word exists.
   */
  Word get(String name);

  /**
   * Puts a word into the dictionary.
   * Uses the name of the word as the dictionary key.
   *
   * @param word the input word
   * @return the modified dictionary.
   */
  Dictionary put(Word word);

}
