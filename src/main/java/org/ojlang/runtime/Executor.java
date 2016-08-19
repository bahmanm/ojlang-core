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

import org.ojlang.models.Xt;
import org.ojlang.models.contracts.SystemState;
import org.ojlang.models.contracts.SystemWord;

/**
 * The executor infinite loop.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Executor {

  static public void
  run(
    SystemState systat
  ) {
    while (true) {
      Object obj = systat.mem().get(systat.xp());
      if (obj == null)
        executeObject(systat, null);
      else if (obj.getClass().equals(Xt.class))
        executeWord(systat, (Xt) obj);
      else if (obj.getClass().equals(Return.class))
        executeReturn(systat, (Return) obj);
      else
        executeObject(systat, obj);
    }
  }

  static private SystemState
  executeWord(
    SystemState systat, Xt xt
  ) {
    if (xt.value() < systat.sysMemSize()) {
      String wordName = (String) systat.mem().get(
        xt.value()
      );
      SystemWord word = (SystemWord) systat.dict().get(wordName);
      word.execute(systat);
      systat.xp(
        systat.xp() + 1
      );
    } else {
      systat.rs().push(
        systat.xp() + 1
      );
      systat.xp(
        xt.value()
      );
    }
    return systat;
  }

  static private SystemState
  executeReturn(
    SystemState systat, Return ret
  ) {
    systat.xp(
      systat.rs().pop()
    );
    return systat;
  }

  static private SystemState
  executeObject(
    SystemState systat, Object obj
  ) {
    systat.ps().push(obj);
    systat.xp(
      systat.xp() + 1
    );
    return systat;
  }

}
