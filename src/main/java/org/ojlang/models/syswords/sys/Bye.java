package org.ojlang.models.syswords.sys;

import org.ojlang.models.contracts.SystemState;
import org.ojlang.models.syswords.AbstractSystemWord;

/**
 * ( -- )
 * Quits Oj and shuts down the JVM with code 0.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Bye extends AbstractSystemWord {

  @Override
  public SystemState execute(SystemState systat) {
    System.exit(0);
    return systat;
  }

  @Override
  public String name() {
    return "BYE";
  }

}
