package org.ojlang.models;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.ConcurrentHashMap;
import org.ojlang.exceptions.WordNotFoundException;
import org.ojlang.models.contracts.Dictionary;
import org.ojlang.models.contracts.Word;

/**
 * Dictionary implementation based on a map.
 *
 * @see Dictionary
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class DictionaryImpl implements Dictionary {

  final static private long serialVersionUID = 6251354072851968198L;

  final private MutableMap<String, Word> delegate = new ConcurrentHashMap<>();

  @Override
  public Word get(
    String name
  ) {
    assert(name != null && name.length() > 0);
    if (delegate.contains(name))
      return delegate.get(name);
    else
      throw new WordNotFoundException(name);
  }

  @Override
  public Dictionary put(
    Word word
  ) {
    assert(word != null);
    delegate.put(word.name(), word);
    return this;
  }

}
