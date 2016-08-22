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
package org.ojlang.sysdef.impls;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.val;
import org.ojlang.sysdef.*;

/**
 * @see Systat
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true, chain = true)
public class OjSystat implements Systat {

  final static private long serialVersionUID = -4885444008905872758L;

  @Getter @Setter
  private Mem mem;

  @Getter @Setter
  private Dict dict;

  @Getter @Setter
  private RS rs;

  @Getter @Setter
  private PS ps;

  @Getter @Setter
  private int xp;

  @Getter @Setter
  private int sysMemSize;

}
