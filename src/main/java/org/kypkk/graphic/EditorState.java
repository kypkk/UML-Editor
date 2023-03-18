package org.kypkk.graphic;

import org.kypkk.core.events.StateEvent;
import org.kypkk.core.events.StateListener;

public class EditorState {

  private final Editor editor;
  private EditorOP op = EditorOP.SELECT;

  public EditorState(Editor editor){
    this.editor = editor;
  }

  public EditorOP getOp(){
    return op;
  }

  public void setOp(EditorOP op){
    this.op = op;
    setOpEvent();
  }

  public void setOpEvent(){
    for(StateListener listener: editor.getStateListeners()){
      listener.changeState(new StateEvent(editor));
    }
  }

  public enum EditorOP{
    SELECT, ASSOCIATION_LINE, GENERALIZATION_LINE, COMPOSITION_LINE, CLASS, USE_CASE
  }
}
