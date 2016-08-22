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

import org.ojlang.sysdef.RS;

/**
 * Oj return stack.
 *
 * @see RS
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class MutableRS extends MutableArrayStack<Integer> implements RS {

  final static private long serialVersionUID = -9044284763242681153L;

}
