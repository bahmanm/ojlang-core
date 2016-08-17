package org.ojlang.models.syswords.math

import org.junit.Test

import static org.ojlang.TestUtils.freshSystat

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class AddTest {

  @Test
  void execute() {
    def systat = freshSystat()
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
