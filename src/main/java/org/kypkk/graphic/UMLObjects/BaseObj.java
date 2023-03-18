package org.kypkk.graphic.UMLObjects;

import javax.swing.*;
import java.awt.*;

public abstract class BaseObj extends JComponent {
  protected int depth;

  @Override
  public abstract void paintComponent(Graphics g);
}
