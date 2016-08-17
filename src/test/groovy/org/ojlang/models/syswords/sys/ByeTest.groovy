package org.ojlang.models.syswords.sys

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.ExpectedSystemExit
import org.ojlang.runtime.Runtime

import static org.junit.Assert.fail
import static org.ojlang.TestUtils.freshSystat

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class ByeTest {

  @Rule
  public ExpectedSystemExit exitRule = ExpectedSystemExit.none()

  @Test
  void execute() throws Exception {
    exitRule.expectSystemExitWithStatus(0)
    new Bye().execute(freshSystat())
  }

  @Test
  void name() throws Exception {
    assert new Bye().name() == 'BYE'
  }

}
