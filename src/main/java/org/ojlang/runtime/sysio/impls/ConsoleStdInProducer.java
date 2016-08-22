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
import lombok.val;
import org.ojlang.exceptions.SysIoException;
import org.ojlang.runtime.sysio.StdIn;
import org.ojlang.runtime.sysio.StdInProducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console StdIn producer.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class ConsoleStdInProducer implements StdInProducer {

  private StdIn stdin;
  private boolean isShutdown = false;

  @Override
  public StdInProducer stdIn(StdIn stdin) {
    this.stdin = stdin;
    return this;
  }

  @Synchronized
  @Override
  public void isShutdown(boolean isShutdown) {
    this.isShutdown = isShutdown;
  }

  @Override
  public void run() {
    if (stdin == null)
      throw new RuntimeException("Invalid StdIn.");
    else {
      val reader = new BufferedReader(new InputStreamReader(System.in));
      while (!isShutdown) {
        try {
          stdin.put(reader.readLine());
        } catch (IOException e) {
          throw new SysIoException(e);
        }
      }
    }
  }

}
