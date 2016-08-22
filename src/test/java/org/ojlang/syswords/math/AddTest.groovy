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
package org.ojlang.syswords.math

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.ojlang.runtime.Runtime

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class AddTest {

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
  void execute() {
    runtime.systat.ps().push(8 as Integer)
    runtime.systat.ps().push(9 as Integer)
    def w = new Add()
    def result = w.execute(runtime.systat())
    assert result.ps().size() == 1
    assert result.ps().peek() == 17
  }

  @Test
  void name() {
    assert new Add().name() == 'ADD'
  }

}
