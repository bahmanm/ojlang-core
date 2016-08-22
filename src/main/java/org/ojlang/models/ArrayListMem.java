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
package org.ojlang.models;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.ojlang.exceptions.InvalidMemoryAddressException;
import org.ojlang.models.contracts.Mem;

import java.util.List;

/**
 * Mem implementation based on an array list.
 *
 * @see Mem
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class ArrayListMem implements Mem {

  final static private long serialVersionUID = 1533347084298802483L;

  final private List<Object> delegate = FastList.newList();

  @Override
  public int
  size() {
    return delegate.size();
  }

  @Override
  public Object
  get(int addr) {
    if (addr < 0)
      throw new InvalidMemoryAddressException(addr);
    return delegate.get(addr);
  }

  @Override
  public Mem
  add(Object obj) {
    delegate.add(obj);
    return this;
  }

  @Override
  public Mem
  put(
    Object obj, int addr
  ) {
    if (addr < 0)
      throw new InvalidMemoryAddressException(addr);
    delegate.set(addr, obj);
    return this;
  }

}
