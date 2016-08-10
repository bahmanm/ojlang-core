package org.ojlang.models.syswords;

import org.ojlang.models.contracts.SystemState;

/**
 * Interpreter word.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Interpreter extends AbstractSystemWord {

  final static private long serialVersionUID = -1299211002338774173L;

  @Override
  public SystemState
  execute(
    SystemState systat
  ) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String name() {
    return "INTERPRETER";
  }

}
