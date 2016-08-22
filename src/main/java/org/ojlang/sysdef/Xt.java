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
package org.ojlang.sysdef;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Represents an execution token (e.g. a memory address to jump to).
 * Though this class is a simple wrapper for an `int`, wihtout it the
 * interpreter/executor couldn't tell if an `int` in memory is simply a number
 * to push to PS or is a memory address to jump to.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class Xt implements Serializable {

  final static private long serialVersionUID = 41600880904248460L;

  @Getter
  private int value;

  public Xt(int value) {
    this.value = value;
  }

}
