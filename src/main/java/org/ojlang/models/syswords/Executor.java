package org.ojlang.models.syswords;

import org.ojlang.models.contracts.SystemState;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Executor extends AbstractSystemWord {

  final static private long serialVersionUID = 2676320309358760392L;

  @Override
  public void
  execute(
    SystemState systat
  ) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String name() {
    return "EXECUTOR";
  }

}
