package org.kypkk.graphic.UMLObjects;

import java.awt.*;

public class UseCaseObj extends UMLObj{

  public UseCaseObj(int x, int y){
    super(x, y, "UseCaseObj");
    setSize(new Dimension(110, 60));

    lineable = true;
    ungroupable = false;
  }

  @Override
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.drawString(getName(), 19, 33);
    g2d.drawOval(5,5,100, 50);
    g2d.setPaint(Color.BLACK);
    paintComponentPorts(g);
  }
}
