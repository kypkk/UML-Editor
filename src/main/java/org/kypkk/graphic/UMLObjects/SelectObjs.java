package org.kypkk.graphic.UMLObjects;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class SelectObjs extends JPanel {
  private int x;
  private int y;

  public SelectObjs(int x, int y){
    super();
    this.x = x;
    this.y = y;
  }

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public void select_dragging(int mouseX, int mouseY) {
    setLocation(Math.min(mouseX, x), Math.min(mouseY, y));
    setSize(Math.abs(mouseX - x), Math.abs(mouseY - y));
  }

  @Override
  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(218, 218, 218, 80));
    g2d.fillRect(0, 0, getWidth(), getHeight());
  }
}
