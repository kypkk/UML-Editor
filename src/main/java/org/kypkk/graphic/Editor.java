package org.kypkk.graphic;

import org.kypkk.core.ResourceManage;
import org.kypkk.core.events.StateEvent;
import org.kypkk.core.events.StateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Editor extends JPanel {

  private final JButton selectBtn;
  private final JButton associationLineBtn;
  private final JButton generalizationLineBtn;
  private final JButton compositionLineBtn;
  private final JButton classBtn;
  private final JButton useCaseBtn;
  private final UMLCanvas canvas;
  private final EditorState state;

  private static Editor instance = null;

  // editor constructor
  public Editor(){

    instance = this;

    // Editor state
    state = new EditorState();

    // set Background
    this.setBackground(new Color(255, 255, 255, 139));

    // buttons on the left
    selectBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/select.png")),  EditorState.EditorOP.SELECT);
    associationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/association.png")),  EditorState.EditorOP.ASSOCIATION_LINE);
    generalizationLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/generalization.png")), EditorState.EditorOP.GENERALIZATION_LINE);
    compositionLineBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/composition.png")), EditorState.EditorOP.COMPOSITION_LINE);
    classBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/class.png")),  EditorState.EditorOP.CLASS);
    useCaseBtn = new EditorButton(new ImageIcon(ResourceManage.getResource("icons/usecase.png")), EditorState.EditorOP.USE_CASE);

    // UMLCanvas on the right
    canvas = new UMLCanvas();
    canvas.setSize(new Dimension(720,720));
    canvas.setBackground(new Color(155, 195, 248));


    // panel and canvas layout setting
    add(canvas);
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);

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

  public EditorState getState(){
    return this.state;
  }

  public void addStateListener(StateListener listener){
    listenerList.add(StateListener.class, listener);
  }

  public StateListener[] getStateListeners(){
    return this.getListeners(StateListener.class);
  }

  public static Editor getInstance(){
    return instance;
  }

  public UMLCanvas getCanvas(){
    return this.canvas;
  }
}
