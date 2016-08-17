package org.ojlang

import org.ojlang.models.SystemStateImpl
import org.ojlang.models.contracts.SystemState

import static org.ojlang.models.ModelFactory.*

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class TestUtils {

  static SystemState freshSystat() {
    SystemStateImpl.create(
      createMem(),
      createDict(),
      createRS(),
      createPS(),
      0,
      0
    )
  }

}
