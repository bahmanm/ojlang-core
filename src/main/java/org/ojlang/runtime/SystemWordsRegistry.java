package org.ojlang.runtime;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.ojlang.models.contracts.SystemWord;
import org.ojlang.models.syswords.Interpreter;
import org.ojlang.models.syswords.io.Puts;
import org.ojlang.models.syswords.sys.Bye;

import java.io.Serializable;

/**
 * Registry of Oj system words.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class SystemWordsRegistry implements Serializable {

  final static private long serialVersionUID = 4672296437456620599L;

  @Accessors(fluent=true) @Getter
  final private static FastList<SystemWord> words = FastList.newListWith(
    new Interpreter(),
    new Puts(),
    new Bye()
  );

  static public int size() {
    return words.size();
  }

}
