package org.ojlang.models.syswords.math

import org.junit.Test
import org.ojlang.models.DictionaryImpl
import org.ojlang.models.MemoryImpl
import org.ojlang.models.ParamStackImpl
import org.ojlang.models.ReturnStackImpl
import org.ojlang.models.SystemStateImpl

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class AddTest {

  @Test
  void execute() {
    def systat = SystemStateImpl.create(
      new MemoryImpl(),
      new DictionaryImpl(),
      new ReturnStackImpl(),
      new ParamStackImpl(),
      0,
      0
    )
    systat.ps().push(8 as Integer)
    systat.ps().push(9 as Integer)
    def w = new Add()
    def result = w.execute(systat)
    assert result.ps().size() == 1
    assert result.ps().peek() == 17
  }

  @Test
  void name() {
    assert new Add().name() == 'ADD'
  }

}
