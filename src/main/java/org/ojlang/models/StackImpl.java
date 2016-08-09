package org.ojlang.models;

import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class StackImpl<T> implements org.ojlang.models.contracts.Stack<T> {

  final static private long serialVersionUID = 2430546690528947971L;

  final private MutableStack<T> delegate = new ArrayStack<>();

  @Override
  public T
  pop() {
    return delegate.pop();
  }

  @Override
  public int
  size() {
    return delegate.size();
  }

  @Override
  public org.ojlang.models.contracts.Stack
  clear() {
    delegate.clear();
    return this;
  }

  @Override
  public org.ojlang.models.contracts.Stack
  push(
    T arg
  ) {
    delegate.push(arg);
    return this;
  }

  @Override
  public T peek(
    int index
  ) {
    return delegate.peekAt(index);
  }

  @Override
  public T
  peek() {
    return delegate.peek();
  }

}
