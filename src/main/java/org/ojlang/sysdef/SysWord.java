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
package org.ojlang.sysdef;

/**
 * A system word.
 * A word which is implemented in Java (or any other JVM language). A system
 * word must be registered in Oj runtime in order to be used.
 *
 * @see org.ojlang.runtime.SystemWordsRegistry
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface SysWord extends Word {

  @Override
  default boolean isSystemWord() {
    return true;
  }

  /**
   * Executes the word mutating the system state.
   *
   * @param systat the snapshot of the system state before execution
   */
  Systat execute(
    Systat systat
  );

}
