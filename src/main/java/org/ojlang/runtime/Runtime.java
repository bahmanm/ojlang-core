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

import ch.qos.logback.core.util.ExecutorServiceUtil;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.val;
import org.ojlang.ObjectFactory;
import org.ojlang.runtime.sysio.StdInProducer;
import org.ojlang.runtime.sysio.StdOutConsumer;
import org.ojlang.sysdef.SysWord;
import org.ojlang.sysdef.Systat;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.ojlang.ObjectFactory.*;

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

  @Getter
  private StdInProducer stdInProducer;

  @Getter
  private StdOutConsumer stdOutConsumer;

  private ExecutorService executorService = ExecutorServiceUtil.newExecutorService();

  /**
   * Private constructor.
   *
   * @see #initClean() or {@link #initClean(List)}
   */
  private Runtime() {}

  /**
   * Shuts down Oj runtime.  Calling this method is necessary for a graceful
   * exit of Oj.
   * <ul>
   *   <li>STDIN/OUT handlers</li>
   * </ul>
   */
  public void shutdown() {
    stdOutConsumer.isShutdown(true);
    stdInProducer.isShutdown(true);
  }

  /**
   * Initialises a new instance of Oj runtime.
   * It <ul>
   *   <li>initialises dictionary</li>
   *   <li>return/param stacks with clean states</li>
   *   <li>puts the XT of system words in memory (starting from 0)</li>
   *   <li>sets the XP to the first word immediately after system memory</li>
   *   <li>sets up STDIN and STDOUT</li>
   * </ul>
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
    runtime.systat = createSystat(
      createMem(),
      createDict(),
      createRS(),
      createPS(),
      sysMemsize,
      sysMemsize
    );
    runtime.stdInProducer = createStdInProducer(runtime.systat.stdIn());
    runtime.stdOutConsumer = createStdOutConsumer(runtime.systat.stdOut());
    runtime.executorService.submit(runtime.stdInProducer);
    runtime.executorService.submit(runtime.stdOutConsumer);
    sysWords.forEach(w -> {
      runtime.systat.dict().put(w);
      runtime.systat.mem().add(w.name());
    });
    return runtime;
  }

  /**
   * Calls {@link #initClean(List)} with the value of
   * S{@link SystemWordsRegistry#words} as the argument.
   *
   * @see #initClean(List)
   */
  static public Runtime
  initClean() {
    return initClean(SystemWordsRegistry.words());
  }

}
