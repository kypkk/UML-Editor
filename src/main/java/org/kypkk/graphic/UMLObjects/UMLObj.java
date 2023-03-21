package org.kypkk.graphic.UMLObjects;

import org.kypkk.graphic.Editor;
import org.kypkk.graphic.EditorState;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class UMLObj extends BaseObj {
  protected boolean isSelect = false;
  protected boolean isGroup = false;
  private Point mousePt;

  public UMLObj(){
    super();
    initialize();
  }

  public UMLObj(int x, int y){
    super();
    setLocation(x, y);
    initialize();
  }

  private static UMLObj getTopObj(UMLObj o) {
    if (o.isGroup) {
      o = (UMLObj) o.getParent();
      while (o.isGroup) {
        o = (UMLObj) o.getParent();
      }
    }
    return o;
  }

  public boolean isGroup(){
    return this.isGroup;
  }

  public void setGrouped(boolean isGroup){
    this.isGroup = isGroup;
  }

  public boolean isSelect(){
    return this.isSelect;
  }

  public void setSelected(boolean isSelect){
    this.isSelect = isSelect;
  }

  private void initialize(){
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {
        UMLObj o = (UMLObj) e.getSource();
        EditorState state = editor.getState();
        mousePt = e.getPoint();

        if(state.getOp() == EditorState.EditorOP.SELECT ){
          if(o.isGroup){
            o = (UMLObj) o.getParent();
            while(o.isGroup)
              o = (UMLObj) o.getParent();
          }
          o.isSelect = !isSelect;
          if (o.isSelect)
            state.setSelecteds(new UMLObj[]{o});
          else
            state.setSelecteds(null);

        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });

    addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
          UMLObj o = (UMLObj) e.getSource();
          o = getTopObj(o);
          EditorState state = editor.getState();
          if(state.getOp() == EditorState.EditorOP.SELECT){
            o.isSelect = true;
            int dx = e.getX() - mousePt.x;
            int dy = e.getY() - mousePt.y;
            o.setLocation(o.getX() + dx, o.getY() + dy);
          }



      }

      @Override
      public void mouseMoved(MouseEvent e) {

      }
    });

    editor.addStateListener(e -> {
      UMLObj[] selecteds =((Editor) e.getSource()).getState().getSelecteds();
      if(selecteds == null)
        isSelect = false;
      else{
        boolean inselect = false;

        for(UMLObj s: selecteds){
          if(s.equals(this)){
            inselect = true;
            break;
          }
        }

        if(!inselect)
          isSelect = false;
      }
      repaint();
    });
  }

  protected void paintComponentPorts(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    if(isSelect){
      int x = getWidth();
      int y = getHeight();
      g2d.fillRect(x/2 - 5, -5, 10,10);
      g2d.fillRect(- 5, y/2 - 5, 10,10);
      g2d.fillRect(x - 5, y/2 - 5, 10,10);
      g2d.fillRect(x/2 - 5, y - 5, 10, 10);
    }

  }

}
