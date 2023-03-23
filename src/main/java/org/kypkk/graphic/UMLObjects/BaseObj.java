package org.kypkk.graphic.UMLObjects;

import org.kypkk.graphic.Editor;

import javax.swing.*;
import java.awt.*;

public abstract class BaseObj extends JComponent {
  protected int depth;
  final Editor editor;
  @Override
  public abstract void paintComponent(Graphics g);

  BaseObj(){
    editor = Editor.getInstance();
  }

  public int getDepth(){
    return this.depth;
  }

}
