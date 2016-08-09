package org.ojlang.models.contracts;

import java.io.Serializable;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public interface Dictionary extends Serializable {

  Word get(String name);
  Dictionary put(Word word);

}
