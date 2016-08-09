package org.ojlang.models;

import lombok.val;
import org.ojlang.models.contracts.Word;

/**
 * Represents a user-defined word.
 *
 * @see Word
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class WordImpl implements org.ojlang.models.contracts.Word {

  final static private long serialVersionUID = 350197946204676041L;

  private String name;
  final private StackImpl<Integer> memAddresses = new StackImpl<Integer>();

  private WordImpl() {}

  @Override
  public int
  popAddr() {
    return memAddresses.pop();
  }

  @Override
  public int
  peekAddr() {
    return memAddresses.peek();
  }

  @Override
  public Word
  pushAddr(
    int addr
  ) {
    memAddresses.push(addr);
    return this;
  }

  @Override
  public String
  name() {
    return this.name;
  }

  static public Word create(String name) {
    assert(name != null && !name.isEmpty());
    val result = new WordImpl();
    result.name = name;
    return result;
  }

  static public Word create(String name, int addr) {
    assert(addr >= 0);
    return create(name).pushAddr(addr);
  }

}
