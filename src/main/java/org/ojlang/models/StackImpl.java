package org.ojlang.models;

import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.ojlang.models.contracts.Stack;

/**
 * Implementation of stack based MutableStack from Eclipse Collections.
 *
 * @see Stack
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class StackImpl<T> implements Stack<T> {

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
  public Stack
  clear() {
    delegate.clear();
    return this;
  }

  @Override
  public Stack
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
