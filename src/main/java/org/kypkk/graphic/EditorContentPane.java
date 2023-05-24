package org.kypkk.graphic;

import javax.swing.*;
import java.awt.*;

public class EditorContentPane extends JPanel {
  private final UMLCanvas canvas;
  private final ButtonBar Buttons;
  EditorContentPane(){
    canvas = new UMLCanvas();
    Buttons = new ButtonBar();

    add(canvas);
    add(Buttons);

    // set Background
    this.setBackground(new Color(255, 255, 255, 255));

    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(
      layout.createSequentialGroup()
        .addComponent(Buttons)
        .addComponent(canvas)

    );

    layout.setVerticalGroup(layout.createParallelGroup().addComponent(Buttons).addComponent(canvas));


}

  public UMLCanvas getCanvas(){
    return canvas;
  }

  public ButtonBar getButtons(){
    return Buttons;
  }

}
