package org.kypkk.graphic;

import org.kypkk.core.ResourceManage;

import javax.swing.*;
import java.awt.*;

public class Editor {

  private final JPanel panel;
  private final JButton selectBtn;
  private final JButton associationLineBtn;
  private final JButton generalizationLineBtn;
  private final JButton compositionLineBtn;
  private final JButton classBtn;
  private final JButton useCaseBtn;
  private final UMLCanvas canvas;


  public Editor(){
    panel = new JPanel();

    // buttons on the left
    selectBtn = new EditorButton("select");
    associationLineBtn = new EditorButton("assiociation Line");
    generalizationLineBtn = new EditorButton("generalization Line");
    compositionLineBtn = new EditorButton("composition Line");
    classBtn = new EditorButton("class");
    useCaseBtn = new EditorButton("use Case");

    // UMLCanvas on the right
    canvas = new UMLCanvas();
    canvas.setSize(new Dimension(720,720));

    panel.add(canvas);
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(
      layout.createSequentialGroup().addGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
          .addComponent(selectBtn)
          .addComponent(associationLineBtn)
          .addComponent(generalizationLineBtn)
          .addComponent(compositionLineBtn)
          .addComponent(classBtn)
          .addComponent(useCaseBtn)
      ).addComponent(canvas)
    );

    layout.setVerticalGroup(
      layout.createParallelGroup().addGroup(
        layout.createSequentialGroup()
          .addComponent(selectBtn)
          .addComponent(associationLineBtn)
          .addComponent(generalizationLineBtn)
          .addComponent(compositionLineBtn)
          .addComponent(classBtn)
          .addComponent(useCaseBtn)
      ).addComponent(canvas)
    );
  }

  public JPanel getPanel(){
    return panel;
  }

}
