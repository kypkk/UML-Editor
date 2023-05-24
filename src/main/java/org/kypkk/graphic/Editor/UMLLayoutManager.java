package org.kypkk.graphic.Editor;

import java.awt.*;

public class UMLLayoutManager implements LayoutManager {
  @Override
  public void addLayoutComponent(String name, Component comp) {

  }

  @Override
  public void removeLayoutComponent(Component comp) {

  }

  @Override
  public Dimension preferredLayoutSize(Container parent) {
    return parent.getSize();
  }

  @Override
  public Dimension minimumLayoutSize(Container parent) {
    return parent.getSize();
  }

  @Override
  public void layoutContainer(Container parent) {

  }
}
