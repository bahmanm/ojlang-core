package org.ojlang.runtime

import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.ExpectedSystemExit
import org.junit.contrib.java.lang.system.SystemOutRule
import org.ojlang.models.Xt

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class ExecutorTest {

  @Rule
  public SystemOutRule sysoutRule = new SystemOutRule().enableLog()

  @Rule
  public ExpectedSystemExit sysexitRule = ExpectedSystemExit.none()

  @Test
  void testRun_puts_bye() {
    sysexitRule.expectSystemExitWithStatus(0)
    Executor.run(systat_puts_bye())
    sysoutRule.log == 'Hello, world'
  }

  def systat_puts_bye() {
    def systat = Runtime.initClean(SystemWordsRegistry.words()).systat()
    systat.mem().add(
      sysWordXt('PUTS')
    )
    systat.mem().add(
      sysWordXt('BYE')
    )
    systat.ps().push('Hello, world')
    systat.xp(systat.sysMemSize())
    systat
  }

  @Test
  void testRun_add_puts_bye() {
    sysexitRule.expectSystemExitWithStatus(0)
    Executor.run(systat_add_puts_bye())
    sysoutRule.log == '10 + 20 = 30'
  }

  def systat_add_puts_bye() {
    def systat = Runtime.initClean(SystemWordsRegistry.words()).systat()
    systat.mem().add(
      sysWordXt('PUTS')
    )
    systat.mem().add(
      sysWordXt('ADD')
    )
    systat.mem().add(
      sysWordXt('PUTS')
    )
    systat.mem().add(
      sysWordXt('BYE')
    )
    systat.ps()
      .push(10)
      .push(20)
      .push('10 + 20 = ')
    systat.xp(systat.sysMemSize())
    systat
  }

  def sysWordXt(String name) {
    new Xt(
      SystemWordsRegistry.words().findIndexOf {
        it.name() == name
      }
    )
  }

}
