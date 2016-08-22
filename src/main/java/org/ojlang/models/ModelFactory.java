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
package org.ojlang.models;

import org.ojlang.models.contracts.Dict;
import org.ojlang.models.contracts.Mem;
import org.ojlang.models.contracts.PS;
import org.ojlang.models.contracts.RS;

/**
 * A collection of factory methods to create Oj runtime models.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
final public class ModelFactory {

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

}
