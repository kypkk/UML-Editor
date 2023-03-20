package org.kypkk.graphic;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class SelectObjs extends JPanel {
  private int sel_x;
  private int sel_y;

  public SelectObjs(int x, int y){
    super();
    this.sel_x = x;
    this.sel_y = y;
  }

  public void setX(int x){
    this.sel_x = x;
  }

  public void setY(int y){
    this.sel_y = y;
  }

  public int getSel_X(){
    return this.sel_x;
  }

  public int getSel_Y(){
    return this.sel_y;
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
}
