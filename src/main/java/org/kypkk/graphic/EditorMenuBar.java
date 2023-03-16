package org.kypkk.graphic;

import javax.swing.*;

public class EditorMenuBar extends JMenuBar {

    private final JMenu fileMenu;
    private final JMenu editMenu;

  public EditorMenuBar(){

    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");

    JMenuItem groupItem = new JMenuItem("Group");
    JMenuItem ungroupItem = new JMenuItem("UnGroup");
    JMenuItem changeObjectItem = new JMenuItem("ChangeObject");

    editMenu.add(groupItem);
    editMenu.add(ungroupItem);
    editMenu.add(changeObjectItem);

    add(fileMenu);
    add(editMenu);
  }

}
