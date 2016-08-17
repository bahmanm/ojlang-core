package org.ojlang.models.syswords.math;

import lombok.val;
import org.ojlang.models.contracts.SystemState;
import org.ojlang.models.syswords.AbstractSystemWord;

/**
 * ( n1 n2 -- n3 )
 * Arithmetic "plus" operation.
 *
 * Consumes two elements from the stack and produces the result of addition back
 * into the stack.
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Add extends AbstractSystemWord {

  @Override
  public SystemState execute(SystemState systat) {
    val op1 = (Integer)systat.ps().pop();
    val op2 = (Integer)systat.ps().pop();
    systat.ps().push(op1 + op2);
    return systat;
  }

  @Override
  public String name() {
    return "ADD";
  }

}
