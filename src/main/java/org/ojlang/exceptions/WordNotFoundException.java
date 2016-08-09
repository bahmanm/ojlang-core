package org.ojlang.exceptions;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@ToString
public class WordNotFoundException extends RuntimeException {

  @Getter
  final private String wordName;

  public WordNotFoundException(String wordName) {
    this.wordName = wordName;
  }

}
