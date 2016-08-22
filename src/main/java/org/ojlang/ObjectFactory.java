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
package org.ojlang;

import lombok.val;
import org.ojlang.runtime.sysio.StdIn;
import org.ojlang.runtime.sysio.StdInProducer;
import org.ojlang.runtime.sysio.StdOut;
import org.ojlang.runtime.sysio.StdOutConsumer;
import org.ojlang.runtime.sysio.impls.BlockingStdIn;
import org.ojlang.runtime.sysio.impls.BlockingStdOut;
import org.ojlang.runtime.sysio.impls.ConsoleStdInProducer;
import org.ojlang.runtime.sysio.impls.ConsoleStdOutConsumer;
import org.ojlang.sysdef.*;
import org.ojlang.sysdef.impls.*;

/**
 * A collection of factory methods for almost anything in Oj.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
final public class ObjectFactory {

  /**
   * Creates a new memory.
   *
   * @return a new memory
   */
  static public Mem createMem() {
    return new ArrayListMem();
  }

  /**
   * Creates a new parameter stack.
   *
   * @return a new parameter stack.
   */
  static public PS createPS() {
    return new MutablePS();
  }

  /**
   * Creates a new return stack.
   *
   * @return a new return stack.
   */
  static public RS createRS() {
    return new MutableRS();
  }

  /**
   * Creates a new dictionary.
   *
   * @return a new dictionary.
   */
  static public Dict createDict() {
    return new HashMapDict();
  }

  /**
   * Creates a new stack.
   *
   * @param <T> stack element type
   * @return a new stack
   */
  static public <T> Stack<T> createStack() {
    return new MutableArrayStack<T>();
  }

  /**
   * Creates a system execution state.
   *
   * @param mem system memory
   * @param dict system dictionary
   * @param rs system return stack
   * @param ps system parameter stack
   * @param xp system execution pointer
   * @param sysMemSize system memory size
   * @return a system execution state
   */
  static public Systat
  createSystat(
    Mem mem, Dict dict, RS rs, PS ps,
    int xp, int sysMemSize
  ) {
    val result = new OjSystat();
    result.mem(mem);
    result.dict(dict);
    result.ps(ps);
    result.rs(rs);
    result.xp(xp);
    result.sysMemSize(sysMemSize);
    result.stdIn(createStdIn());
    result.stdOut(createStdOut());
    return result;
  }

  /**
   * Creates a new STDIN.
   *
   * @return a new STDIN
   */
  static public StdIn
  createStdIn() {
    return new BlockingStdIn();
  }

  /**
   * Creates a new STDOUT.
   *
   * @return a new STDOUT
   */
  static public StdOut
  createStdOut() {
    return new BlockingStdOut();
  }

  /**
   * Creates a STDIN producer with the default STDIN.
   *
   * @return a STDIN producer
   */
  static public StdInProducer
  createStdInProducer() {
    val result = new ConsoleStdInProducer();
    result.setStdIn(createStdIn());
    return result;
  }

  /**
   * Creates a STDIN producer.
   *
   * @param stdin STDIN
   * @return a STDIN producer
   */
  static public StdInProducer
  createStdInProducer(
    StdIn stdin
  ) {
    val result = new ConsoleStdInProducer();
    result.setStdIn(stdin);
    return result;
  }

  /**
   * Creates a STDOUT consumer with the default STDOUT.
   *
   * @return a STDOUT consumer
   */
  static public StdOutConsumer
  createStdOutConsumer() {
    val result = new ConsoleStdOutConsumer();
    result.setStdOut(createStdOut());
    return result;
  }

  /**
   * Creates a STDOUT consumer.
   *
   * @param stdout STDOUT
   * @return a STDOUT consumer
   */
  static public StdOutConsumer
  createStdOutConsumer(
    StdOut stdout
  ) {
    val result = new ConsoleStdOutConsumer();
    result.setStdOut(stdout);
    return result;
  }

}
