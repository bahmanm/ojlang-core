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

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.ConcurrentHashMap;
import org.ojlang.exceptions.WordNotFoundException;
import org.ojlang.models.contracts.Dictionary;
import org.ojlang.models.contracts.Word;

/**
 * Dictionary implementation based on a map.
 *
 * @see Dictionary
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class DictionaryImpl implements Dictionary {

  final static private long serialVersionUID = 6251354072851968198L;

  final private MutableMap<String, Word> delegate = new ConcurrentHashMap<>();

  @Override
  public Word get(
    String name
  ) {
    assert(name != null && name.length() > 0);
    if (delegate.containsKey(name))
      return delegate.get(name);
    else
      throw new WordNotFoundException(name);
  }

  @Override
  public Dictionary put(
    Word word
  ) {
    assert(word != null);
    delegate.put(word.name(), word);
    return this;
  }

}
