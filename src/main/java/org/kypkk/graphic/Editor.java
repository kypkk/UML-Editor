package org.kypkk.graphic;

import javax.swing.*;

public class Editor extends JFrame{


  private static Editor instance = null;

  private final EditorState editorState;
  private final EditorContentPane contentPane;


  // editor constructor
  public Editor(){

    instance = this;

    // Editor state
    editorState = new EditorState();
    // content pane
    contentPane = new EditorContentPane();

    setTitle("UML Editor");
    setContentPane(contentPane);
    setJMenuBar(new EditorMenuBar());

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(500, 300, 1600, 900);
    setVisible(true);
    pack();


  }

  public EditorState getEditorState(){
    return editorState;
  }

  public static Editor getInstance(){
    return instance;
  }

  public EditorContentPane getContentPane(){
    return contentPane;
  }


}
