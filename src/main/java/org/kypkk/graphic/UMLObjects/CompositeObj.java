package org.kypkk.graphic.UMLObjects;

import java.awt.*;
import static java.lang.Math.*;
public class CompositeObj extends UMLObj{

  int length;

  public CompositeObj(UMLObj[] UmlObjs){
    super();
    setOpaque(false);
    int x = 0; // x of a single umlobj
    int y = 0; // y of a single umlobj
    int loc_x = 540; // x for the compositeobj
    int loc_y = 540; // y for the compositeobj
    int width = 110; // the width for the compositeobj
    int height = 10; // the height for the composite obj

    for(UMLObj obj: UmlObjs){
      add(obj);
      obj.setGrouped(true);
      loc_x = min(loc_x, obj.getX());
      loc_y = min(loc_y, obj.getY());
    }

    for(UMLObj obj: UmlObjs){
      height += obj.getHeight();
      height -= 10;
    }

    // count how many umlobjs
    length = height / 60 + 1;

    setBounds(loc_x, loc_y, width, height);


    int count = 0;
    for(UMLObj obj: UmlObjs){
      obj.setLocation(x, y);
      y += obj.getHeight() - 10;
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.setPaint(Color.BLACK);
    paintComponentPorts(g);
  }
}
