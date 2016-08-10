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
  private int xp;
  private int sysMemSize;

  private SystemStateImpl() {}

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
  static public SystemStateImpl
  create(
    Memory mem, Dictionary dict, ReturnStack rs, ParamStack ps,
    int xp, int sysMemSize
  ) {
    val result = new SystemStateImpl();
    result.mem = mem;
    result.dict = dict;
    result.ps = ps;
    result.rs = rs;
    result.xp = xp;
    result.sysMemSize = sysMemSize;
    return result;
  }

  @Override
  public Memory mem() {
    return mem;
  }

  @Override
  public Dictionary dict() {
    return dict;
  }

  @Override
  public ReturnStack rs() {
    return rs;
  }

  @Override
  public ParamStack ps() {
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
  public SystemStateImpl
  xp(
    int newXp
  ) {
    xp = newXp;
    return this;
  }

}
