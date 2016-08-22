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

package org.ojlang;

import lombok.val;
import org.ojlang.sysdef.*;
import org.ojlang.sysdef.impls.*;

/**
 * A collection of factory methods for almost anything in Oj.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
final public class ObjectFactory {

  /**
   * Creates a new memory.
   *
   * @return a new memory
   */
  static public Mem createMem() {
    return new ArrayListMem();
  }

  /**
   * Creates a new parameter stack.
   *
   * @return a new parameter stack.
   */
  static public PS createPS() {
    return new MutablePS();
  }

  /**
   * Creates a new return stack.
   *
   * @return a new return stack.
   */
  static public RS createRS() {
    return new MutableRS();
  }

  /**
   * Creates a new dictionary.
   *
   * @return a new dictionary.
   */
  static public Dict createDict() {
    return new HashMapDict();
  }

  /**
   * Creates a new stack.
   *
   * @param <T> stack element type
   * @return a new stack
   */
  static public <T> Stack<T> createStack() {
    return new MutableArrayStack<T>();
  }

  /**
   * Creates a system execution state.
   *
   * @param mem system memory
   * @param dict system dictionary
   * @param rs system return stack
   * @param ps system parameter stack
   * @param xp system execution pointer
   * @param sysMemSize system memory size
   * @return a system execution state
   */
  static public OjSystat
  createSystat(
    Mem mem, Dict dict, RS rs, PS ps,
    int xp, int sysMemSize
  ) {
    val result = new OjSystat();
    result.mem(mem);
    result.dict(dict);
    result.ps(ps);
    result.rs(rs);
    result.xp(xp);
    result.sysMemSize(sysMemSize);
    return result;
  }

}
