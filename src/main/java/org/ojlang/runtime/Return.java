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
package org.ojlang.runtime;

import java.io.Serializable;

/**
 * This has a special meaning to Executor; whenever the XP points to a memory cell
 * which contains a Return instance, the Executor understands that it should pop
 * the RS and continue execution from there.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
final public class Return implements Serializable {

  final static private long serialVersionUID = -8604020529139621449L;

  static final private Return instance = new Return();

  public static Return getInstance() {
    return instance;
  }

  private Return() {
  }

}
