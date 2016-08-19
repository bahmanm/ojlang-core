[![Build Status](https://travis-ci.org/bahmanm/ojlang-core.svg?branch=master)](https://travis-ci.org/bahmanm/ojlang-core) 

**Table of Contents**
- [Introduction](#introduction)
- [Design](#design)
	- [Execution Model](#execution-model)
	- [Data Structures](#data-structures)
	 - [Word](#word)
	 - [Memory](#memory)
	 - [Dictionary](#dictionary)
	 - [Parameter Stack](#parameter-stack)
	 - [Return Stack](#return-stack)
	 - [Execution Pointer](#execution-pointer)
- [Roadmap](#roadmap)
- [License](#license)

# Introduction #
Oj (pronounced like Owl) is a Forth on JVM.

# Design #
*NOTE: As the general design follows the guidlines in
 [Thoughts On JVM-based Forth Implementation](http://www.bahmanm.com/blogs/thoughts-on-jvm-based-forth-implementation)
 it's a good idea to take a few minutes and read the post first.*

## Execution Model ##
*TODO*

## Data Structures ##
Oj runtime is designed to resemble a simple processor architecture.  It consists
of: 
 * a memory space
 * a dictionary
 * a parameter stack
 * a return stack
 * an execution pointer
 * system defined words (extensible)

*NOTE: Currently, all the above are mutable objects which will be modified after every
operation on them.  However, all interfaces have been designed so that a possible
immutable implementation is also possible.*

## Word ##
At the core of Oj, being a Forth, is the concept of a WORD.  In Oj, word definitions are
stored in [Memory](#memory) with the addresses (XTs) stored in the word itself.

A word is somehow similar to functions and methods in other languages but with a
subtle difference: a word may have multiple definitions.  That's why every Oj word
contains a stack of addresses (each pointing to a definition).

## Memory ##
The memory will contain the (system and user) [word](#word) definitions.  In 
contrast with other Forth systems, Oj memory does not contain bytes but rather
JVM objects.

Basic memory operations include:
* `size: int`: should return the count of objects currently in memory
* `add: Object -> Memory`: should add an object at the end of memory space 
and return the modified memory.
* `get: int -> Object`: should return the object at the specified memory 
address.
* `put: Object -> int -> Memory`: should put an object at the specified memory 
address.

## Dictionary ##
The dictionary is the mapping of names to [words](#word).

Basic dictionary operations include:
* `get: String -> Word`: retrieves the word with the specified name.
* `put: Word -> Dictionary`: adds a new word to the dictionary.

## Parameter Stack ##
The PS (parameter stack) is a stack of JVM objects where [words](#word) fetch input parameters and put the 
output results.

Basic PS operations include:
* `pop: Object`: stack pop
* `peek: Object`: stack peek
* `peek: int -> Object`: stack indexed peek
* `push: Object -> ParameterStack`: returns a stack with the object pushed to the
top.
* `clear: ParameterStack`: returns an empty stack

## Return Stack ##
The RS (return stack) is a stack of XTs (execution token).  Executor, upon 
finishing the execution of a [word](#word), jumps back to the calling word.

Basic RS operations include:
* `pop: int`: stack pop
* `peek: int`: stack peek
* `peek: int -> int`: stack indexed peek
* `push: int -> ReturnStack`: returns a stack with the XT pushed to the
top.
* `clear: ReturnStack`: returns an empty stack

## Execution Pointer ##
It is simply the current memory address that is being executed; quite like an `IP`
register in the X86 architecture.

# Roadmap #

## v1.0 ##
FORTH
* FORTH-83 semi-compliance
  + [FORTH-83 required word set](http://forth.sourceforge.net/standard/fst83/fst83-12.htm)

## v2.0 ##
Interoperability
* JVM Interoperability
  + Creating objects
  + Calling methods on objects
* Java Interoperability
  + Implementing interfaces
  + Extending classes

## v3.0 ##
Concurrency and asynchronous word set
* Threads, runnables and tasks
  + [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
  + [FutureTask](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/FutureTask.html)
  + [Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)

## v4.0 ##
Coroutines and seamless async operations word set

## Even farther future ##
* Data persistence (RDBMS, NoSQL)
* Web programming done Forth style
* ...

# License #
Oj is licensed under [Apache License v2.0](http://www.apache.org/licenses/LICENSE-2.0).
