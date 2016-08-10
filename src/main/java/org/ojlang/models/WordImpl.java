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
  final private StackImpl<Xt> memAddresses = new StackImpl<Xt>();

  private WordImpl() {}

  @Override
  public int
  popXt() {
    return memAddresses.pop().value();
  }

  @Override
  public int
  xt() {
    return memAddresses.peek().value();
  }

  @Override
  public Word
  pushXt(
    Xt addr
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

  static public Word create(String name, Xt addr) {
    assert(addr.value() >= 0);
    return create(name).pushXt(addr);
  }

}
