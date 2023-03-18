package org.kypkk;

import org.kypkk.graphic.Editor;
import org.kypkk.graphic.EditorMenuBar;

import javax.swing.*;

public class App {
  public static void main(String[] args) {
    JFrame frame = new JFrame("UML Editor");

    frame.setContentPane(new Editor());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(500, 300, 900, 900);
    frame.setResizable(false);
    frame.pack();
    frame.setJMenuBar(new EditorMenuBar());
    frame.setVisible(true);

  }
}
