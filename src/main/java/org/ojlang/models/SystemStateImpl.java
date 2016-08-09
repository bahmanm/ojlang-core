package org.ojlang.models;

import lombok.val;
import org.ojlang.models.contracts.*;

/**
 * @see SystemState
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class SystemStateImpl implements SystemState {

  final static private long serialVersionUID = -4885444008905872758L;

  private Memory mem;
  private Dictionary dict;
  private ReturnStack rs;
  private ParamStack ps;

  private SystemStateImpl() {}

  /**
   * Creates a system execution state.
   *
   * @param mem system memory
   * @param dict system dictionary
   * @param rs system return stack
   * @param ps system parameter stack
   * @return a system execution state
   */
  static public SystemStateImpl
  create(
    Memory mem, Dictionary dict, ReturnStack rs, ParamStack ps
  ) {
    val result = new SystemStateImpl();
    result.mem = mem;
    result.dict = dict;
    result.ps = ps;
    result.rs = rs;
    return result;
  }

  @Override
  public Memory mem() {
    return null;
  }

  @Override
  public Dictionary dict() {
    return null;
  }

  @Override
  public ReturnStack rs() {
    return null;
  }

  @Override
  public ParamStack ps() {
    return null;
  }

}
