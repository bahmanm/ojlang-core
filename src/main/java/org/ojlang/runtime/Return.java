package org.ojlang.runtime;

/**
 * This has a special meaning to Executor.  Whenever the XP reaches a memory cell
 * which contains a Return instance, the Executor understands that it should pop
 * the RS and continue execution from there.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
final public class Return {

  static final private Return instance = new Return();

  public static Return getInstance() {
    return instance;
  }

  private Return() {
  }

}
