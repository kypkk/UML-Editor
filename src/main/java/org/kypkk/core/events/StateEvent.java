package org.kypkk.core.events;

import java.util.EventObject;

public class StateEvent extends EventObject {

  /*
  * 這將會 construct 一個 event prototype
  *
  * source 就是 event 觸發的物件的source
  *
  * 會 throw IllegalArgumentException 如果 source 是 null
  * */
  public StateEvent (Object source){
    super(source);
  }

}

