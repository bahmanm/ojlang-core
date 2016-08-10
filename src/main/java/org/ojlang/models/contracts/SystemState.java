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
   * System execution pointer
   *
   * @return system execution pointer
   */
  int xp();

  /**
   * Sets a new value for the instruction pointer (i.e. jump).
   *
   * @param newXp new XP
   * @return modified system state
   */
  SystemState xp(int newXp);

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

  /**
   * System memory size; i.e. number of system words registered in Oj
   *
   * @return system memory size
   */
  int sysMemSize();

}
