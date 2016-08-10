package org.ojlang.models.syswords;

import org.ojlang.models.Xt;
import org.ojlang.models.contracts.SystemWord;
import org.ojlang.models.contracts.Word;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
abstract public class AbstractSystemWord implements SystemWord {

  @Override
  public int
  popXt() {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  public int
  xt() {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  public Word
  pushXt(
    Xt addr
  ) {
    throw new RuntimeException("Illegal operation on a system word");
  }

  @Override
  final public boolean
  isSystemWord() {
    return false;
  }

}
