package org.kypkk.graphic.Editor;

import org.kypkk.graphic.UMLObjects.UMLObj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class SelectObjs extends JPanel {
  final private int sel_x;
  final private int sel_y;


  public SelectObjs(int x, int y){
    super();
    this.sel_x = x;
    this.sel_y = y;
  }



  public void select_dragging(int mouseX, int mouseY) {
    setLocation(Math.min(mouseX, sel_x), Math.min(mouseY, sel_y));
    setSize(Math.abs(mouseX - sel_x), Math.abs(mouseY - sel_y));
  }

  @Override
  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(218, 218, 218, 80));
    g2d.fillRect(0, 0, getWidth(), getHeight());
  }

  public void selectUMLObjs(Component[] components){
    ArrayList<UMLObj> selectedList = new ArrayList<>();
    for(var compo: components){
      // only select the UMLObjs
      if(compo instanceof UMLObj obj){
        // check if UMLObj is in the selectObjs'
        if(compo.getX() > getX() && compo.getX() + compo.getWidth() < getX() + getWidth() && compo.getY() > getY() && compo.getHeight() + compo.getY() < getY() + getHeight() && !obj.isGroup()){
          obj.setSelected(true);
          selectedList.add(obj);
        }

      }
    }

    UMLObj[] selectedOBJlist = new UMLObj[selectedList.size()];
    Editor.getInstance().getEditorState().setSelecteds(selectedList.toArray(selectedOBJlist));
  }

}
