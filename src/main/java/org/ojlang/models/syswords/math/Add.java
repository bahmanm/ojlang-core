/*
 * Copyright 2016 Bahman Movaqar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
