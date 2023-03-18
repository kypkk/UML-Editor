package org.kypkk.graphic;

import javax.swing.*;
import java.awt.*;

public class EditorButton extends JButton{

  private final Editor editor;
  private final EditorState.EditorOP op;

  EditorButton(Icon icon, Editor editor, EditorState.EditorOP op){
    super(icon);
    this.editor = editor;
    this.op = op;
    initialize(this.op);
  }

  private void initialize(EditorState.EditorOP op){

    setBackground(Color.WHITE);

    setMargin(new Insets(0, 0, 0, 0));

    if(op == EditorState.EditorOP.SELECT)
      setBackground(Color.BLACK);

    addActionListener(e -> {
      editor.getState().setOp(this.op);
    });

    editor.addStateListener(e -> {
      Editor editor = (Editor) e.getSource();

      if (editor.getState().getOp() == this.op) {
        setBackground(Color.BLACK);
        System.out.println(this.op+" is choosed");
      } else {
        setBackground(Color.WHITE);
        System.out.println(this.op+" is unchoosed");

      }
    });
  }

}
