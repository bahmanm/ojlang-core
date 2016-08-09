package org.ojlang.runtime;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.ojlang.models.contracts.SystemWord;

/**
 * Registry of Oj system words.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class SystemWordsRegistry {

  @Accessors(fluent=true) @Getter
  final private static FastList<SystemWord> words = FastList.newListWith();

  static public int size() {
    return words.size();
  }

}
