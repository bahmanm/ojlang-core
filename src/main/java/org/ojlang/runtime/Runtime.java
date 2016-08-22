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
import lombok.val;
import org.ojlang.ObjectFactory;
import org.ojlang.sysdef.SysWord;
import org.ojlang.sysdef.Systat;

import java.io.Serializable;
import java.util.List;

/**
 * Oj runtime.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class Runtime implements Serializable {

  final static private long serialVersionUID = 8428732629851491287L;

  @Getter
  private Systat systat;

  /**
   * Private constructor.  Use `init`.
   */
  private Runtime() {}

  /**
   * Initialises a new instance of Oj runtime.
   * It basically initialises dictionary, return/param stacks with clean states,
   * puts the XT of system words in memory (starting from 0) and sets the XP to
   * the first word immediately after system memory.
   *
   * @see SystemWordsRegistry
   * @param sysWords system words
   * @return a new instance of runtime
   */
  static public Runtime
  initClean(
    List<SysWord> sysWords
  ) {
    assert(sysWords != null);
    val runtime = new Runtime();
    val sysMemsize = sysWords.size();
    runtime.systat = ObjectFactory.createSystat(
      ObjectFactory.createMem(),
      ObjectFactory.createDict(),
      ObjectFactory.createRS(),
      ObjectFactory.createPS(),
      sysMemsize,
      sysMemsize
    );
    sysWords.forEach(w -> {
      runtime.systat.dict().put(w);
      runtime.systat.mem().add(w.name());
    });
    return runtime;
  }

}
