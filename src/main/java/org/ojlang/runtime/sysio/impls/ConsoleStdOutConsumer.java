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
package org.ojlang.runtime.sysio.impls;

import lombok.Synchronized;
import org.ojlang.runtime.sysio.StdOut;
import org.ojlang.runtime.sysio.StdOutConsumer;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class ConsoleStdOutConsumer implements StdOutConsumer {

  private StdOut stdout;
  private boolean isShutdown = false;

  @Override
  public StdOutConsumer stdOut(StdOut stdout) {
    this.stdout = stdout;
    return this;
  }

  @Synchronized
  @Override
  public void isShutdown(boolean isShutdown) {
    this.isShutdown = isShutdown;
  }

  @Override
  public void run() {
    if (stdout == null)
      throw new RuntimeException("Invalid StdOut");
    else
      while(!isShutdown) {
        String s = stdout.get();
        if (s != null)
          System.out.print(s);
      }
  }

}
