package org.kypkk.graphic;

import javax.swing.*;
import java.awt.*;

public class EditorButton extends JButton{

  private final Editor editor;
  private final EditorState.EditorOP op;

  EditorButton(Icon icon, EditorState.EditorOP op){
    super(icon);
    editor = Editor.getInstance();
    this.op = op;
    initialize(this.op);
  }

  private void initialize(EditorState.EditorOP op){

    setBackground(Color.WHITE);

    setMargin(new Insets(0, 0, 0, 0));

    if(op == EditorState.EditorOP.SELECT)
      setBackground(Color.BLACK);

    addActionListener(e -> editor.getEditorState().setOp(this.op));

    editor.getEditorState().addStateListener(e -> {
      Editor editor = (Editor) e.getSource();

      if (editor.getEditorState().getOp() == this.op) {
        this.setBackground(Color.BLACK);
      } else {
        this.setBackground(Color.WHITE);
      }
    });
  }

}
