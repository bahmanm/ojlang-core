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
package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * Oj dictionary; a mapping of names to words.
 *
 * @see Word
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Dict extends Serializable {

  /**
   * Retrieves a word by its name.
   *
   * @param name the input name
   * @return the word; should throw a runtime exception if no such word exists.
   */
  Word get(String name);

  /**
   * Puts a word into the dictionary.
   * Uses the name of the word as the dictionary key.
   *
   * @param word the input word
   * @return the modified dictionary.
   */
  Dict put(Word word);

}
