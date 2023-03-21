package org.kypkk.graphic;

import javax.swing.*;

public class EditorMenuBar extends JMenuBar {
    private final Editor editor;
    private final JMenu fileMenu;
    private final JMenu editMenu;

  public EditorMenuBar(){
    editor = Editor.getInstance();
    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");

    JMenuItem groupItem = new JMenuItem("Group");
    JMenuItem ungroupItem = new JMenuItem("UnGroup");
    JMenuItem changeObjectItem = new JMenuItem("ChangeObject");

    groupItem.addActionListener(e -> {
      editor.getCanvas().createCompositeObj();
      editor.getState().setSelecteds(null);
      System.out.println("group");
    });
    ungroupItem.addActionListener(e -> {
      editor.getCanvas().ungroupCompositeObj();
      editor.getState().setSelecteds(null);
      System.out.println("ungroup");
    });

    editMenu.add(groupItem);
    editMenu.add(ungroupItem);
    editMenu.add(changeObjectItem);

    add(fileMenu);
    add(editMenu);
  }

}
