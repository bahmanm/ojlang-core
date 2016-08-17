package org.ojlang.runtime;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.val;
import org.ojlang.models.*;
import org.ojlang.models.contracts.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.ojlang.models.ModelFactory.*;

/**
 * Oj runtime.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class Runtime implements Serializable {

  final static private long serialVersionUID = 8428732629851491287L;

  @Getter
  private SystemState systat;

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
    List<SystemWord> sysWords
  ) {
    assert(sysWords != null);
    val runtime = new Runtime();
    val sysMemsize = sysWords.size();
    runtime.systat = SystemStateImpl.create(
      createMem(),
      createDict(),
      createRS(),
      createPS(),
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
