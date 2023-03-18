package org.kypkk.graphic;

import org.kypkk.graphic.UMLObjects.ClassObj;
import org.kypkk.graphic.UMLObjects.UseCaseObj;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This is a class that paint UML objects on Canvas
 */


public class UMLCanvas extends JPanel {

  private final Editor editor;

  public UMLCanvas (Editor editor){
    super(new UMLLayoutManager());
    this.editor = editor;

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
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        System.out.println("released");
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
      }

      @Override
      public void mouseMoved(MouseEvent e) {
        System.out.println("moving");
      }
    });
  }

  public void createClassObj(int x, int y){
    this.add(new ClassObj(x, y));
    this.repaint();
  }

  public void createUsecaseObj(int x, int y){
    this.add(new UseCaseObj(x, y));
    this.repaint();
  }

}
