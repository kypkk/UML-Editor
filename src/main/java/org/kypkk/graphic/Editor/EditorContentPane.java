package org.kypkk.graphic.Editor;

import javax.swing.*;
import java.awt.*;

public class EditorContentPane extends JPanel {
  private final UMLCanvas canvas;

  EditorContentPane(){
    canvas = new UMLCanvas();
    ButtonBar buttons = new ButtonBar();

    add(canvas);
    add(buttons);

    canvas.setSize(new Dimension(1120,720));
    canvas.setBackground(new Color(155, 195, 248));
    // set Background
    this.setBackground(new Color(255, 255, 255, 255));

    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(
      layout.createSequentialGroup()
        .addComponent(buttons)
        .addComponent(canvas)

    );

    layout.setVerticalGroup(layout.createParallelGroup().addComponent(buttons).addComponent(canvas));


}

  public UMLCanvas getCanvas(){
    return canvas;
  }

}
