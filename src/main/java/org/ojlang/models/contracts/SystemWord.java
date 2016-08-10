package org.ojlang.models.contracts;

/**
 * A system word.
 * A word which is implemented in Java (or any other JVM language). A system
 * word must be registered in Oj runtime in order to be used.
 *
 * @see org.ojlang.runtime.SystemWordsRegistry
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface SystemWord extends Word {

  @Override
  default boolean isSystemWord() {
    return true;
  }

  /**
   * Executes the word mutating the system state.
   *
   * @param systat the snapshot of the system state before execution
   */
  SystemState execute(
    SystemState systat
  );

}
