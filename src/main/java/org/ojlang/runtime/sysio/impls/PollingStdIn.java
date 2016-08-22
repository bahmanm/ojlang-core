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

import org.ojlang.exceptions.SysIoException;
import org.ojlang.runtime.sysio.StdIn;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * A blocking STDIN based on a blocking queue.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class PollingStdIn implements StdIn, Serializable {

  final static private long serialVersionUID = 3929204405969181558L;
  final static private int DEFAULT_CAPACITY = 1000;

  final private BlockingQueue<String> data;

  /**
   * Creates a new instance with a given capacity.
   *
   * @param capacity the given capacity
   */
  public PollingStdIn(int capacity) {
    data = new ArrayBlockingQueue<>(capacity);
  }

  /**
   * Creates a new instance with the default capacity (i.e. 1000).
   */
  public PollingStdIn() {
    data = new ArrayBlockingQueue<>(DEFAULT_CAPACITY);
  }

  /**
   * Gets the next available chunk from the queue.
   *
   * @return next available chunk or null if none is ready.
   */
  @Override
  public String get() {
    return data.poll();
  }

  @Override
  public void put(String chunk) {
    try {
      data.put(chunk);
    } catch (InterruptedException e) {
      throw new SysIoException(e);
    }
  }

}
