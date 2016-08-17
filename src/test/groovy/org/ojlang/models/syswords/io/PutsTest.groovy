package org.ojlang.models.syswords.io

import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule

import static org.ojlang.TestUtils.freshSystat

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class PutsTest {

  @Rule
  public SystemOutRule sysoutRule = new SystemOutRule().enableLog()

  @Test
  void execute() throws Exception {
    def systat = freshSystat()
    systat.ps().push('Hello, world')
    new Puts().execute(systat)
    assert sysoutRule.log == 'Hello, world'
    assert systat.ps().size() == 0
  }

  @Test
  void name() throws Exception {
    assert new Puts().name() == 'PUTS'
  }

}
