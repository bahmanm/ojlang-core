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

import lombok.val;
import org.ojlang.sysdef.*;

/**
 * @see Systat
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class OjSystat implements Systat {

  final static private long serialVersionUID = -4885444008905872758L;

  private Mem mem;
  private Dict dict;
  private RS rs;
  private PS ps;
  private int xp;
  private int sysMemSize;

  private OjSystat() {}

  /**
   * Creates a system execution state.
   *
   * @param mem system memory
   * @param dict system dictionary
   * @param rs system return stack
   * @param ps system parameter stack
   * @param xp system execution pointer
   * @param sysMemSize system memory size
   * @return a system execution state
   */
  static public OjSystat
  create(
    Mem mem, Dict dict, RS rs, PS ps,
    int xp, int sysMemSize
  ) {
    val result = new OjSystat();
    result.mem = mem;
    result.dict = dict;
    result.ps = ps;
    result.rs = rs;
    result.xp = xp;
    result.sysMemSize = sysMemSize;
    return result;
  }

  @Override
  public Mem mem() {
    return mem;
  }

  @Override
  public Dict dict() {
    return dict;
  }

  @Override
  public RS rs() {
    return rs;
  }

  @Override
  public PS ps() {
    return ps;
  }

  @Override
  public int xp() {
    return xp;
  }

  @Override
  public int sysMemSize() {
    return sysMemSize;
  }

  @Override
  public OjSystat
  xp(
    int newXp
  ) {
    xp = newXp;
    return this;
  }

}
