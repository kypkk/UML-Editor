package org.kypkk.graphic.Editor;

import org.kypkk.core.ResourceManage;
import org.kypkk.graphic.Editor.Button.EditorButton;

import javax.swing.*;

public class ButtonBar extends JPanel{


  ButtonBar(){
    // buttons on the left
    JButton selectBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/select.png")),  EditorState.EditorOP.SELECT);
    JButton associationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/association.png")),  EditorState.EditorOP.ASSOCIATION_LINE);
    JButton generalizationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/generalization.png")), EditorState.EditorOP.GENERALIZATION_LINE);
    JButton compositionLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/composition.png")), EditorState.EditorOP.COMPOSITION_LINE);
    JButton classBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/class.png")),  EditorState.EditorOP.CLASS);
    JButton useCaseBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/usecase.png")), EditorState.EditorOP.USE_CASE);

    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(
      layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
          .addComponent(selectBtn)
          .addComponent(associationLineBtn)
          .addComponent(generalizationLineBtn)
          .addComponent(compositionLineBtn)
          .addComponent(classBtn)
          .addComponent(useCaseBtn)
        )
    );

    layout.setVerticalGroup(layout.createParallelGroup().addGroup(layout.createSequentialGroup()
      .addComponent(selectBtn)
      .addComponent(associationLineBtn)
      .addComponent(generalizationLineBtn)
      .addComponent(compositionLineBtn)
      .addComponent(classBtn)
      .addComponent(useCaseBtn)));
  }
}
