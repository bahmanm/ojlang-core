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
package org.ojlang.syswords.sys

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.ExpectedSystemExit
import org.ojlang.runtime.Runtime

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class ByeTest {

  @Rule
  public ExpectedSystemExit exitRule = ExpectedSystemExit.none()

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
  void execute() throws Exception {
    exitRule.expectSystemExitWithStatus(0)
    new Bye().execute(runtime.systat())
  }

  @Test
  void name() throws Exception {
    assert new Bye().name() == 'BYE'
  }

}
