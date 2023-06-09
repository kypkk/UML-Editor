package org.kypkk.graphic.UMLObjects;

import java.awt.*;
import static java.lang.Math.*;
public class CompositeObj extends UMLObj{

  int length;

  public CompositeObj(UMLObj[] UmlObjs){
    super();
    setOpaque(false);
    int loc_x = 540; // x for the compositeobj
    int loc_y = 540; // y for the compositeobj
    int width = 0; // the width for the compositeobj
    int height = 0; // the height for the composite obj

    lineable = false;
    ungroupable = true;

    for(UMLObj obj: UmlObjs){
      add(obj);
      obj.setGrouped(true);
      loc_x = min(loc_x, obj.getX());
      loc_y = min(loc_y, obj.getY());
    }

    for(UMLObj obj: UmlObjs){
      width = max(obj.getX() + 110 - loc_x, width);
      height = max(obj.getY() + obj.getHeight() - loc_y, height);
    }

    // count how many umlobjs
    length = height / 60 + 1;

    setBounds(loc_x, loc_y, width, height);


    for(UMLObj obj: UmlObjs){
      obj.setLocation(obj.getX() - loc_x, obj.getY() - loc_y);
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.setPaint(Color.BLACK);
  }
}
