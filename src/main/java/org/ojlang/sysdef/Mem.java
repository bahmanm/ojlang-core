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

import java.io.Serializable;

/**
 * Mem space.
 * The granularity of memory cells is JVM object in contrast to normal Forth
 * systems whose cells are just bytes.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Mem extends Serializable {

  /**
   * Retrieves the current size of the memory.
   *
   * @return the current size of the memory
   */
  int size();

  /**
   * Retries a cell (i.e. JVM object) by its address.
   *
   * @param addr memory address
   * @return the object at the given address; should throw a runtime exception
   *  if the address is invalid.
   */
  Object get(int addr);

  /**
   * Adds an object to the memory (e.g. append)
   *
   * @param obj the given object
   * @return the modified memory
   */
  Mem add(Object obj);

  /**
   * Puts an object at a given address overriding its previous contents.
   *
   * @param obj the input object
   * @param addr the input memory address
   * @return the modified memory
   */
  Mem put(Object obj, int addr);

}
