package org.ojlang.models;

import org.ojlang.models.contracts.Dictionary;
import org.ojlang.models.contracts.Memory;
import org.ojlang.models.contracts.ParamStack;
import org.ojlang.models.contracts.ReturnStack;

/**
 * A collection of factory methods to create Oj runtime models.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
final public class ModelFactory {

  /**
   * Creates a new memory.
   *
   * @return a new memory
   */
  static public Memory createMem() {
    return new MemoryImpl();
  }

  /**
   * Creates a new parameter stack.
   *
   * @return a new parameter stack.
   */
  static public ParamStack createPS() {
    return new ParamStackImpl();
  }

  /**
   * Creates a new return stack.
   *
   * @return a new return stack.
   */
  static public ReturnStack createRS() {
    return new ReturnStackImpl();
  }

  /**
   * Creates a new dictionary.
   *
   * @return a new dictionary.
   */
  static public Dictionary createDict() {
    return new DictionaryImpl();
  }

}
