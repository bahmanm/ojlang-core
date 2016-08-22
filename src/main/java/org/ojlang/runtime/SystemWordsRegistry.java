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
package org.ojlang.runtime;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.ojlang.models.contracts.SysWord;
import org.ojlang.models.syswords.Interpreter;
import org.ojlang.models.syswords.io.Puts;
import org.ojlang.models.syswords.math.Add;
import org.ojlang.models.syswords.sys.Bye;

import java.io.Serializable;

/**
 * Registry of Oj system words.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class SystemWordsRegistry implements Serializable {

  final static private long serialVersionUID = 4672296437456620599L;

  @Accessors(fluent=true) @Getter
  final private static FastList<SysWord> words = FastList.newListWith(
    new Interpreter(),
    new Puts(),
    new Bye(),
    new Add()
  );

  static public int size() {
    return words.size();
  }

}
