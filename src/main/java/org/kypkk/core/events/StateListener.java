package org.kypkk.core.events;

import java.util.EventListener;

public interface StateListener extends EventListener {
  /*
  * StateEvent 的 listener
  * */
  void changeState(StateEvent e);
}
