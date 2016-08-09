package org.ojlang.exceptions;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@ToString
public class InvalidMemoryAddressException extends RuntimeException {

  @Getter
  final private int memAddr;

  public InvalidMemoryAddressException(int memAddr) {
    this.memAddr = memAddr;
  }

}
