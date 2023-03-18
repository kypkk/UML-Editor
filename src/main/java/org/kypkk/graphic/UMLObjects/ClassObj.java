package org.kypkk.graphic.UMLObjects;

import java.awt.*;

public class ClassObj extends UMLObj{

  public ClassObj(int x, int y) {
    super(x, y);
    setSize(new Dimension(100, 50));
  }

  @Override
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.drawRect(0,0,100, 50);
    g2d.setPaint(Color.BLACK);
  }
}
