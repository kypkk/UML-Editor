package org.kypkk.graphic.UMLObjects;

import java.awt.*;

public class ClassObj extends UMLObj{

  public ClassObj(int x, int y) {
    super(x, y, "ClassObj");
    setSize(new Dimension(110, 100));


  }

  @Override
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.drawString(getName(), 27, 20);
    g2d.drawRect(5,5,100, 30);
    g2d.drawRect(5, 35,100, 30);
    g2d.drawRect(5, 65,100, 30);
    g2d.setPaint(Color.BLACK);
    paintComponentPorts(g);
  }
}
