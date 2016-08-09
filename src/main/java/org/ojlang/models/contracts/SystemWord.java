package org.ojlang.models.contracts;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface SystemWord extends Word {

  @Override
  default boolean isSystemWord() {
    return true;
  }

  void execute(
    Memory mem,
    ParamStack ps,
    ReturnStack rs
  );

}
