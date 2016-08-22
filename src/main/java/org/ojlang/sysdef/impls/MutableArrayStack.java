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

import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.ojlang.sysdef.Stack;

/**
 * Implementation of stack based MutableStack from Eclipse Collections.
 *
 * @see Stack
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class MutableArrayStack<T> implements Stack<T> {

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
