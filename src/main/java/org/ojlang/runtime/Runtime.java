package org.ojlang.runtime;

import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.val;
import org.ojlang.models.DictionaryImpl;
import org.ojlang.models.MemoryImpl;
import org.ojlang.models.ParamStackImpl;
import org.ojlang.models.ReturnStackImpl;
import org.ojlang.models.contracts.Dictionary;
import org.ojlang.models.contracts.Memory;
import org.ojlang.models.contracts.ParamStack;
import org.ojlang.models.contracts.ReturnStack;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class Runtime {

  @Getter
  final private Dictionary dict = new DictionaryImpl();

  @Getter
  final private Memory mem = new MemoryImpl();

  @Getter
  final private ReturnStack rs = new ReturnStackImpl();

  @Getter
  final private ParamStack ps = new ParamStackImpl();

  @Getter
  final private int sysMemSize = SystemWordsRegistry.size();

  private Runtime() {}

  static public Runtime setup() {
    val runtime = new Runtime();
    SystemWordsRegistry.words().each(w -> {
      runtime.dict.put(w);
      runtime.mem.add(w.name());
    });
    return runtime;
  }

}
