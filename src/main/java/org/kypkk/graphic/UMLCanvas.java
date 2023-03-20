package org.kypkk.graphic;

import org.kypkk.graphic.UMLObjects.ClassObj;
import org.kypkk.graphic.UMLObjects.UseCaseObj;
import static java.lang.Math.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This is a class that paint UML objects on Canvas
 */


public class UMLCanvas extends JPanel {

  private final Editor editor;
  private SelectObjs selectObjs;

  public UMLCanvas (){
    super(new UMLLayoutManager());
    editor = Editor.getInstance();

    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
      }

      @Override
      public void mousePressed(MouseEvent e) {
        System.out.println("pressed");

        switch(editor.getState().getOp()){
          case CLASS -> {
            createClassObj(e.getX(), e.getY());
            break;
          }
          case USE_CASE -> {
            createUsecaseObj(e.getX(), e.getY());
            break;
          }
        }
        if(editor.getState().getOp() == EditorState.EditorOP.SELECT){
          editor.getState().setSelected(null);

          selectObjs = new SelectObjs(e.getX(), e.getY());
          add(selectObjs);
          selectObjs.repaint();
        }
        System.out.println("pressed");
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        System.out.println("released");
        if(editor.getState().getOp() == EditorState.EditorOP.SELECT && selectObjs != null){
          remove(selectObjs);
          selectObjs = null;
          repaint();
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        System.out.println("entered");
      }

      @Override
      public void mouseExited(MouseEvent e) {
        System.out.println("exited");
      }
    });

    addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
        System.out.println("dragged");
        int mouseX;
        int mouseY;

        mouseX = max(e.getX(), 0);
        mouseY = max(e.getY(), 0);



        if(editor.getState().getOp() == EditorState.EditorOP.SELECT && selectObjs != null){
          selectObjs.select_dragging(mouseX, mouseY);

        }
      }

      @Override
      public void mouseMoved(MouseEvent e) {
        System.out.println("moving");
      }
    });
  }

  public void createClassObj(int x, int y){
    add(new ClassObj(x, y));
    repaint();
  }

  public void createUsecaseObj(int x, int y){
    add(new UseCaseObj(x, y));
    repaint();
  }

}
