package org.ojlang.models.syswords;

import org.ojlang.models.MemoryAddress;
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
    MemoryAddress addr
  ) {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  final public boolean
  isSystemWord() {
    return false;
  }

}
