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
package org.ojlang.runtime.sysio;

/**
 * Runtime system STDERR.
 * A producer (e.g. an Oj word) "puts" chunks of data while a consumer (e.g.
 * console) "gets" chunks of data.
 *
 * NOTE: Oj expects nothing smaller than a word; for example single characters
 * are not to be "put".
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface StdErr {

  /**
   * Returns the next available chunk of data which depending on the impl may
   * or may not block.
   *
   * @return the next available chunk of data which could be a single word, a
   * line of code or multiple lines of code.
   */
  String get();

  /**
   * Adds a given chunk of data to be later "consumed" (i.e. "get").  Depending
   * on the impl, it may or may not block.
   *
   * @param chunk the given chunk of data
   */
  void put(String chunk);

}
