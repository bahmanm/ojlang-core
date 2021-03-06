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
package org.ojlang.sysdef.impls;

import lombok.val;
import org.ojlang.ObjectFactory;
import org.ojlang.sysdef.Stack;
import org.ojlang.sysdef.Xt;
import org.ojlang.sysdef.Word;

/**
 * Represents a user-defined word.
 *
 * @see Word
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class WordImpl implements Word {

  final static private long serialVersionUID = 350197946204676041L;

  private String name;
  final private Stack<Xt> xts = ObjectFactory.createStack();

  private WordImpl() {}

  @Override
  public int
  popXt() {
    return xts.pop().value();
  }

  @Override
  public int
  xt() {
    return xts.peek().value();
  }

  @Override
  public Word
  pushXt(
    Xt addr
  ) {
    xts.push(addr);
    return this;
  }

  @Override
  public String
  name() {
    return this.name;
  }

  static public Word create(String name) {
    assert(name != null && !name.isEmpty());
    val result = new WordImpl();
    result.name = name;
    return result;
  }

  static public Word create(String name, Xt addr) {
    assert(addr.value() >= 0);
    return create(name).pushXt(addr);
  }

}
