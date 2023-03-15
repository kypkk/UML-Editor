package org.kypkk.graphic;

import org.kypkk.core.ResourceManage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    selectBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("select.png")));
    associationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("association.png")));
    generalizationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("generalization.png")));
    compositionLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("composition.png")));
    classBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("class.png")));
    useCaseBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("usecase.png")));

    // UMLCanvas on the right
    canvas = new UMLCanvas();
    canvas.setSize(new Dimension(540,540));
    canvas.setBackground(Color.DARK_GRAY);

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
