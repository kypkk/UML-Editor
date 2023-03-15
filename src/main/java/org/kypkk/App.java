package org.kypkk;

import org.kypkk.graphic.Editor;

import javax.swing.*;
import java.awt.*;

public class App {
  public static void main(String[] args) {
    JFrame frame = new JFrame("UML Editor");

    frame.setContentPane(new Editor().getPanel());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

  }
}
