package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * A snapshot of the system execution state, including memory, dictionary,
 * return stack and parameter stack.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface SystemState extends Serializable {

  /**
   * System memory.
   *
   * @return system memory
   */
  Memory mem();

  /**
   * System dictionary
   *
   * @return system dictionary
   */
  Dictionary dict();

  /**
   * System return stack
   *
   * @return system return stack
   */
  ReturnStack rs();

  /**
   * System parameter stack
   *
   * @return system parameter stack
   */
  ParamStack ps();

}
