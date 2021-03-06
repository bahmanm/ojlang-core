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

import org.ojlang.runtime.sysio.StdIn;
import org.ojlang.runtime.sysio.StdOut;

import java.io.Serializable;

/**
 * A snapshot of the system execution state, including memory, dictionary,
 * return stack and parameter stack.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Systat extends Serializable {

  /**
   * System execution pointer
   *
   * @return system execution pointer
   */
  int xp();

  /**
   * Sets a new value for the instruction pointer (i.e. jump).
   *
   * @param newXp new XP
   * @return modified system state
   */
  Systat xp(int newXp);

  /**
   * System memory.
   *
   * @return system memory
   */
  Mem mem();

  /**
   * System dictionary
   *
   * @return system dictionary
   */
  Dict dict();

  /**
   * System return stack
   *
   * @return system return stack
   */
  RS rs();

  /**
   * System parameter stack
   *
   * @return system parameter stack
   */
  PS ps();

  /**
   * System memory size; i.e. number of system words registered in Oj
   *
   * @return system memory size
   */
  int sysMemSize();

  /**
   * STDIN
   *
   * @return STDIN
   */
  StdIn stdIn();

  /**
   * STDOUT
   *
   * @return STDOUT
   */
  StdOut stdOut();

}
