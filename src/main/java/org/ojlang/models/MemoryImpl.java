package org.ojlang.models;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.ojlang.exceptions.InvalidMemoryAddressException;
import org.ojlang.models.contracts.Memory;

import java.util.List;

/**
 * Memory implementation based on an array list.
 *
 * @see Memory
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class MemoryImpl implements Memory {

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
  public Memory
  add(Object obj) {
    delegate.add(obj);
    return this;
  }

  @Override
  public Memory
  put(
    Object obj, int addr
  ) {
    if (addr < 0)
      throw new InvalidMemoryAddressException(addr);
    delegate.set(addr, obj);
    return this;
  }

}
