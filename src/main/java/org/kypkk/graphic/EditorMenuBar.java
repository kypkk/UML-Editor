package org.kypkk.graphic;

import org.kypkk.graphic.UMLObjects.UMLObj;

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
      for(UMLObj obj: editor.getEditorState().getSelecteds()){
        JFrame jf = new JFrame();
        String getMessage = JOptionPane.showInputDialog(jf, obj.getName());
        obj.setName(getMessage);
        System.out.println(getMessage);
      }
    });

    editMenu.add(groupItem);
    editMenu.add(ungroupItem);
    editMenu.add(changeObjectItem);

    add(fileMenu);
    add(editMenu);
  }

}
