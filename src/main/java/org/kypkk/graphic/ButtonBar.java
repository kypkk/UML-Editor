package org.kypkk.graphic;

import org.kypkk.core.ResourceManage;

import javax.swing.*;

public class ButtonBar extends JPanel{
  private final JButton selectBtn;
  private final JButton associationLineBtn;
  private final JButton generalizationLineBtn;
  private final JButton compositionLineBtn;
  private final JButton classBtn;
  private final JButton useCaseBtn;

  ButtonBar(){
    // buttons on the left
    selectBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/select.png")),  EditorState.EditorOP.SELECT);
    associationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/association.png")),  EditorState.EditorOP.ASSOCIATION_LINE);
    generalizationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/generalization.png")), EditorState.EditorOP.GENERALIZATION_LINE);
    compositionLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/composition.png")), EditorState.EditorOP.COMPOSITION_LINE);
    classBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/class.png")),  EditorState.EditorOP.CLASS);
    useCaseBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/usecase.png")), EditorState.EditorOP.USE_CASE);

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
