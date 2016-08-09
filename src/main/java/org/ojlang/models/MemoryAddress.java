package org.ojlang.models;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class MemoryAddress {

  @Getter
  private int value;

  public MemoryAddress(int value) {
    this.value = value;
  }

}
