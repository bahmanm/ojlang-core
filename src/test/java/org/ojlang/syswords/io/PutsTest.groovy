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
package org.ojlang.syswords.io

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import org.ojlang.runtime.Runtime

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class PutsTest {

  @Rule
  public SystemOutRule sysoutRule = new SystemOutRule().enableLog()

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
    runtime.systat().ps().push('Hello, world')
    new Puts().execute(runtime.systat())
    sleep(100)
    assert sysoutRule.log == 'Hello, world'
    assert runtime.systat().ps().size() == 0
  }

  @Test
  void name() throws Exception {
    assert new Puts().name() == 'PUTS'
  }

}
