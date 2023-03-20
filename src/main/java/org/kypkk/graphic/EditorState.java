package org.kypkk.graphic;

import org.kypkk.core.events.StateEvent;
import org.kypkk.core.events.StateListener;
import org.kypkk.graphic.UMLObjects.UMLObj;

public class EditorState {

  private UMLObj[] selecteds;

  private final Editor editor;
  private EditorOP op = EditorOP.SELECT;

  public EditorState(){
    editor = Editor.getInstance();
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

  public UMLObj[] getSelecteds() {
    return selecteds;
  }

  public void setSelecteds(UMLObj[] selecteds) {
    this.selecteds = selecteds;
    setOpEvent();
  }

  public enum EditorOP{
    SELECT, ASSOCIATION_LINE, GENERALIZATION_LINE, COMPOSITION_LINE, CLASS, USE_CASE
  }
}
