/*
 * Copyright 2016 Bahman Movaqar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ojlang.runtime

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.ExpectedSystemExit
import org.junit.contrib.java.lang.system.SystemOutRule
import org.ojlang.sysdef.Xt
import org.ojlang.sysdef.impls.WordImpl

import static org.junit.Assert.fail

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class ExecutorTest {

  @Rule
  public SystemOutRule sysoutRule = new SystemOutRule().enableLog()

  @Rule
  public ExpectedSystemExit sysexitRule = ExpectedSystemExit.none()

  Runtime runtime

  @Before
  void initRuntime() {
    runtime = Runtime.initClean()
  }

  @After
  void shutdownRuntime() {
    runtime.shutdown()
  }

  @Test
  void testRun_puts_bye() {
    sysexitRule.expectSystemExitWithStatus(0)
    Executor.run(systat_puts_bye())
    sysoutRule.log == 'Hello, world'
  }

  def systat_puts_bye() {
    runtime.systat().with {
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        sysWordXt('BYE')
      )
      ps().push('Hello, world')
      xp(runtime.systat().sysMemSize())
    }
    runtime.systat()
  }

  @Test
  void testRun_add_puts_bye() {
    sysexitRule.expectSystemExitWithStatus(0)
    Executor.run(systat_add_puts_bye())
    sysoutRule.log == '10 + 20 = 30'
    runtime.shutdown()
  }

  def systat_add_puts_bye() {
    runtime.systat().with {
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        sysWordXt('ADD')
      )
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        sysWordXt('BYE')
      )
      ps()
        .push(10)
        .push(20)
        .push('10 + 20 = ')
      xp(sysMemSize())
    }
    runtime.systat()
  }

  @Test
  void testRun_user_word_bye() {
    sysexitRule.expectSystemExitWithStatus(0)
    Executor.run(systat_user_word_bye())
    sysoutRule.log == 'Result = 30'
  }

  def systat_user_word_bye() {
    def myWordXt = new Xt(SystemWordsRegistry.words().size() + 4)
    runtime.systat().with {
      dict().put(
        WordImpl.create('MY-WORD', myWordXt)
      )

      mem().add(
        10
      )
      mem().add(
        20
      )
      mem().add(
        myWordXt
      )
      mem().add(
        sysWordXt('BYE')
      )
      // MY-WORD
      mem().add(
        'Result =  '
      )
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        sysWordXt('ADD')
      )
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        Return.instance
      )
      xp(sysMemSize())
    }
    runtime.systat()
  }

  @Test
  void testRun_user_word_user_word_bye() {
    sysexitRule.expectSystemExitWithStatus(0)
    Executor.run(systat_user_word_user_word_bye())
    sysoutRule.log == 'INSIDE INSIDE 12'
  }

  def systat_user_word_user_word_bye() {
    def myWordXt = new Xt(SystemWordsRegistry.words().size() + 5)
    runtime.systat().with {
      dict().put(
        WordImpl.create('MY-WORD', myWordXt)
      )

      mem().add(
        10
      )
      mem().add(
        myWordXt
      )
      mem().add(
        myWordXt
      )
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        sysWordXt('BYE')
      )
      // MY-WORD
      mem().add(
        'INSIDE '
      )
      mem().add(
        sysWordXt('PUTS')
      )
      mem().add(
        1
      )
      mem().add(
        sysWordXt('ADD')
      )
      mem().add(
        Return.instance
      )
      xp(sysMemSize())
    }
    runtime.systat()
  }

  @Test
  void testRun_null_add_bye() {
    def systat = systat_null_puts_bye()
    try {
      Executor.run(systat)
      fail('should have thrown NPE')
    } catch (NullPointerException) {
      assert systat.ps().size() == 0
    }
  }

  def systat_null_puts_bye() {
    runtime.systat().with {
      mem().add(
        null
      )
      mem().add(
        sysWordXt('ADD')
      )
      mem().add(
        sysWordXt('BYE')
      )
      ps().push(1)
      xp(sysMemSize())
    }
    runtime.systat()
  }

  def sysWordXt(String name) {
    new Xt(
      SystemWordsRegistry.words().findIndexOf {
        it.name() == name
      }
    )
  }

}
