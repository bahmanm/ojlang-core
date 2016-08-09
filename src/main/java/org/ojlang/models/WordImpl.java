package org.ojlang.models;

import lombok.val;
import org.ojlang.models.contracts.Word;

/**
 * Represents a user-defined word.
 *
 * @see Word
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class WordImpl implements Word {

  final static private long serialVersionUID = 350197946204676041L;

  private String name;
  final private StackImpl<MemoryAddress> memAddresses = new StackImpl<MemoryAddress>();

  private WordImpl() {}

  @Override
  public int
  popAddr() {
    return memAddresses.pop().value();
  }

  @Override
  public int
  peekAddr() {
    return memAddresses.peek().value();
  }

  @Override
  public Word
  pushAddr(
    MemoryAddress addr
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

  static public Word create(String name, MemoryAddress addr) {
    assert(addr.value() >= 0);
    return create(name).pushAddr(addr);
  }

}
