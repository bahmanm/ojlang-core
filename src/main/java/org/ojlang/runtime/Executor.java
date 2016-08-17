package org.ojlang.runtime;

import org.ojlang.models.Xt;
import org.ojlang.models.contracts.SystemState;

/**
 * The executor infinite loop.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Executor {

  static public void
  run(
    SystemState systat
  ) {
    while (true) {
      Object obj = systat.mem().get(systat.xp());
      if (obj.getClass().equals(Xt.class)) {
        systat.rs().push(
          systat.xp() + 1
        );
        systat.xp(
          ((Xt)obj).value()
        );
      } else if (obj.getClass().equals(Return.class)) {
        systat.xp(
          systat.rs().pop()
        );
      } else {
        systat.ps().push(obj);
        systat.xp(
          systat.xp() + 1
        );
      }
    }
  }

}
