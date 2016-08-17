package org.ojlang.models.syswords.io;

import org.ojlang.models.contracts.SystemState;
import org.ojlang.models.syswords.AbstractSystemWord;

/**
 * (String -- )
 * Prints a string to STDOUT.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Puts extends AbstractSystemWord {

  @Override
  public SystemState execute(SystemState systat) {
    System.out.print(systat.ps().pop());
    return systat;
  }

  @Override
  public String name() {
    return "PUTS";
  }

}
