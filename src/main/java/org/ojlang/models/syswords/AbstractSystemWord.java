package org.ojlang.models.syswords;

import org.ojlang.models.contracts.SystemWord;
import org.ojlang.models.contracts.Word;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
abstract public class AbstractSystemWord implements SystemWord {

  @Override
  public int
  popAddr() {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  public int
  peekAddr() {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  public Word
  pushAddr(
    int addr
  ) {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  public String name() {
    return null;
  }

  @Override
  final public boolean
  isSystemWord() {
    return false;
  }

}
