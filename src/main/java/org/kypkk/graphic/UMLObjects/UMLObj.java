package org.kypkk.graphic.UMLObjects;

import org.kypkk.graphic.Editor;
import org.kypkk.graphic.EditorState;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static java.lang.Math.*;

public abstract class UMLObj extends BaseObj {
  protected boolean isSelect = false;
  protected boolean isGroup = false;
  private Point mousePt; // use for dragging obj
  private static creatingLine line = null;
  private String name;

  private void initialize(){
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {
        UMLObj o = (UMLObj) e.getSource();
        EditorState state = editor.getEditorState();


        if(state.getOp() == EditorState.EditorOP.SELECT ){
          mousePt = e.getPoint();
          o = getTopObj(o);
          ArrayList<UMLObj> list = new ArrayList<UMLObj>();
          list.add((UMLObj)o);
          for(var obj: o.getComponents()){
            ((UMLObj)obj).setSelected(!((UMLObj)obj).isSelect());
            if (((UMLObj)obj).isSelect())
              list.add((UMLObj)obj);
          }
          state.setSelecteds(list.toArray(UMLObj[]::new));


        } else if(state.getOp() == EditorState.EditorOP.ASSOCIATION_LINE || state.getOp() == EditorState.EditorOP.COMPOSITION_LINE || state.getOp() == EditorState.EditorOP.GENERALIZATION_LINE && !o.isGroup() && !(o instanceof CompositeObj)){
          var line = new creatingLine();
          System.out.println("creating line");
          switch(state.getOp()){
            case ASSOCIATION_LINE -> line.type = LineObj.Linetype.ASSOCIATION_LINE;
            case GENERALIZATION_LINE -> line.type = LineObj.Linetype.GENERALIZATION_LINE;
            case COMPOSITION_LINE -> line.type = LineObj.Linetype.COMPOSITION_LINE;
          }
          line.start_port = getPortDirection(e.getX(), e.getY());
          UMLObj.line = line;
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        UMLObj o = (UMLObj) e.getSource();
        EditorState state = editor.getEditorState();

        if(line!= null && state.getOp() == EditorState.EditorOP.ASSOCIATION_LINE || state.getOp() == EditorState.EditorOP.COMPOSITION_LINE || state.getOp() == EditorState.EditorOP.GENERALIZATION_LINE && !o.isGroup()&& !(o instanceof CompositeObj)){

          int mouse_x = o.getX() + e.getX();
          int mouse_y = o.getY() + e.getY();


          UMLObj end_obj = null;

          for(var compo: editor.getContentPane().getCanvas().getComponents()){

              if(mouse_x > compo.getX() && mouse_x < compo.getX() + compo.getWidth() && mouse_y > compo.getY() && mouse_y < compo.getY() + compo.getHeight()){
                if(end_obj == null || end_obj.getDepth() > ((UMLObj) compo).getDepth()){
                  end_obj = (UMLObj)compo;
                }
              }

          }

          if(end_obj != null){
            editor.getContentPane().getCanvas().createLineObj(o, end_obj, line.start_port, end_obj.getPortDirection(mouse_x - end_obj.getX(), mouse_y - end_obj.getY()), line.type);
            System.out.println("line created");

          }
          line = null;
        }

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
        EditorState state = editor.getEditorState();
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

    editor.getEditorState().addStateListener(e -> {
      UMLObj[] selecteds =((Editor) e.getSource()).getEditorState().getSelecteds();
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

  public UMLObj(){
    super();
    initialize();
  }

  public UMLObj(int x, int y, String name){
    super();
    setLocation(x, y);
    this.name = name;
    initialize();
  }

  public static UMLObj getTopObj(UMLObj o) {
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

  public Point getPortPoint(portDirection direction){
    Point return_p = new Point();
    if(this.isGroup){
      switch(direction){
        case TOP -> return_p =  new Point(getX() + 60 + getTopObj(this).getX(), getY() + 5 + getTopObj(this).getY());
        case BOTTOM -> return_p = new Point(getX() + 60 + getTopObj(this).getX(), getY() + getHeight() - 5 + getTopObj(this).getY());
        case LEFT -> return_p = new Point(getX() + 5 + getTopObj(this).getX(), (int)(getY() + 0.5*getHeight()) + getTopObj(this).getY());
        case RIGHT -> return_p = new Point(getX() + getWidth() - 5 + getTopObj(this).getX(), (int)(getY() + 0.5*getHeight()) + getTopObj(this).getY());
      };
    }else{
      switch(direction){
        case TOP -> return_p =  new Point(getX() + 60 , getY() + 5 );
        case BOTTOM -> return_p = new Point(getX() + 60 , getY() + getHeight() - 5 );
        case LEFT -> return_p = new Point(getX() + 5 , (int)(getY() + 0.5*getHeight()));
        case RIGHT -> return_p = new Point(getX() + getWidth() - 5 , (int)(getY() + 0.5*getHeight()));
      };
    }

    return return_p;
  }

  public portDirection getPortDirection(int mouseX, int mouseY){
    portDirection ret_port;

    double top_d = sqrt(pow(mouseX - 60, 2) + pow(mouseY - 5, 2));
    double left_d = sqrt(pow(mouseX - 5, 2) + pow(mouseY - getHeight()/2, 2));
    double bottom_d = sqrt(pow(mouseX - 60, 2) + pow(mouseY - getHeight() - 5, 2));
    double right_d = sqrt(pow(mouseX - 105, 2) + pow(mouseY - getHeight()/2, 2));


    double min_d = min(top_d, left_d);
    min_d = min(min_d, bottom_d);
    min_d = min(min_d, right_d);

    if(min_d == top_d)
      ret_port = portDirection.TOP;
    else if(min_d == left_d)
      ret_port = portDirection.LEFT;
    else if(min_d == bottom_d)
      ret_port = portDirection.BOTTOM;
    else
      ret_port = portDirection.RIGHT;

    return ret_port;
  }

  public enum portDirection{
    TOP, RIGHT, BOTTOM, LEFT
  }

  private class creatingLine{
    public LineObj.Linetype type;
    public UMLObj.portDirection start_port;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

}
