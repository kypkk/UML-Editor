package org.kypkk.graphic.Editor;


import javax.swing.*;

public class EditorMenuBar extends JMenuBar {
    private final Editor editor;

  public EditorMenuBar(){
    editor = Editor.getInstance();
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");

    JMenuItem groupItem = new JMenuItem("Group");
    JMenuItem ungroupItem = new JMenuItem("UnGroup");
    JMenuItem changeObjectItem = new JMenuItem("ChangeObject");

    groupItem.addActionListener(e -> {
      editor.getContentPane().getCanvas().createCompositeObj();
      editor.getEditorState().setSelecteds(null);
      System.out.println("group");
    });
    ungroupItem.addActionListener(e -> {
      editor.getContentPane().getCanvas().ungroupCompositeObj();
      editor.getEditorState().setSelecteds(null);
      System.out.println("ungroup");
    });
    changeObjectItem.addActionListener(e -> {
      editor.getContentPane().getCanvas().changeObjectItem();
      editor.getEditorState().setSelecteds(null);
    });

    editMenu.add(groupItem);
    editMenu.add(ungroupItem);
    editMenu.add(changeObjectItem);

    add(fileMenu);
    add(editMenu);
  }

}
