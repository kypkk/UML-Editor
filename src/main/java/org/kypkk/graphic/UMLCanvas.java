package org.kypkk.graphic;

import org.kypkk.graphic.UMLObjects.*;

import static java.lang.Math.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * This is a class that paint UML objects on Canvas
 */


public class UMLCanvas extends JPanel{

  private final Editor editor;
  private SelectObjs selectObjs;
  private final ArrayList<LineObj> lineObjArrayList;
  public  int startpointX, endpointX;
  public  int startpointY, endpointY;

  public UMLCanvas (){
    super(new UMLLayoutManager());
    editor = Editor.getInstance();
    lineObjArrayList = new ArrayList<LineObj>();

    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
      }

      @Override
      public void mousePressed(MouseEvent e) {
        System.out.println("pressed");

        switch(editor.getEditorState().getOp()){
          case CLASS -> {
            createClassObj(e.getX(), e.getY());
            break;
          }
          case USE_CASE -> {
            createUsecaseObj(e.getX(), e.getY());
            break;
          }
        }
        if(editor.getEditorState().getOp() == EditorState.EditorOP.SELECT){
          editor.getEditorState().setSelecteds(null);

          selectObjs = new SelectObjs(e.getX(), e.getY());
          add(selectObjs);
          selectObjs.repaint();
        }
        System.out.println("pressed");
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        System.out.println("released");
        if(editor.getEditorState().getOp() == EditorState.EditorOP.SELECT && selectObjs != null){

          selectObjs.selectUMLObjs(getComponents());

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

        if(editor.getEditorState().getOp() == EditorState.EditorOP.SELECT && selectObjs != null){
          int mouseX;
          int mouseY;

          mouseX = max(e.getX(), 0);
          mouseY = max(e.getY(), 0);
          selectObjs.select_dragging(mouseX, mouseY);

        }

      }

      @Override
      public void mouseMoved(MouseEvent e) {
        System.out.println("moving");
      }
    });
  }

  public void createCompositeObj(){
    UMLObj[] selectedObjs = editor.getEditorState().getSelecteds();
    if(selectedObjs != null && selectedObjs.length > 1){
      for(UMLObj obj : selectedObjs)
        remove(obj);
      add(new CompositeObj(selectedObjs));
      repaint();
    }
  }

  public void ungroupCompositeObj(){
    UMLObj[] selectedObjs = editor.getEditorState().getSelecteds();
    if(selectedObjs != null && selectedObjs[0] instanceof CompositeObj){
      CompositeObj Compo = (CompositeObj) selectedObjs[0];
      remove(Compo);

      for(var obj: Compo.getComponents()){
        Compo.remove(obj);
        add(obj);
        ((UMLObj)obj).setGrouped(false);
        obj.setLocation(obj.getX() + Compo.getX(), obj.getY() + Compo.getY());
      }
      repaint();
    }
  }

  public void createClassObj(int x, int y){
    add(new ClassObj(x, y));
    repaint();
  }

  public void createUsecaseObj(int x, int y){
    add(new UseCaseObj(x, y));
    repaint();
  }

  public void createLineObj(UMLObj start_obj, UMLObj end_obj, UMLObj.portDirection start_port, UMLObj.portDirection end_port, LineObj.Linetype type ){
    lineObjArrayList.add(new LineObj(start_obj, end_obj, start_port, end_port, type));
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(3));
    for(var line: lineObjArrayList){
      UMLObj start_obj = line.getStart_obj();
      UMLObj end_obj = line.getEnd_obj();
      Point start_point = start_obj.getPortPoint(line.getStart_port());
      Point end_point = end_obj.getPortPoint(line.getEnd_port());
      switch (line.getType()) {
        case ASSOCIATION_LINE -> {
          paintArrow(g, (int) start_point.getX() , (int) start_point.getY(), (int) end_point.getX(), (int) end_point.getY());

        }
        case GENERALIZATION_LINE -> {
          paintTriangle(g, (int) start_point.getX() , (int) start_point.getY(), (int) end_point.getX(), (int) end_point.getY());
        }
        case COMPOSITION_LINE -> {
          paintDiamond(g, (int) start_point.getX() , (int) start_point.getY(), (int) end_point.getX(), (int) end_point.getY());
        }
      }
    }
    repaint();

  }

  public void paintArrow(Graphics g, int start_x, int start_y, int end_x, int end_y){
    int arrowW = 10, arrowH = 10;
    g.drawLine(start_x, start_y, end_x, end_y);
    int dx = end_x - start_x, dy = end_y - start_y;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
    double sin = dy/D, cos = dx/D;
    x = xm*cos - ym*sin + start_x;
    ym = xm*sin + ym*cos + start_y;
    xm = x;
    x = xn*cos - yn*sin + start_x;
    yn = xn*sin + yn*cos + start_y;
    xn = x;


    g.drawLine(end_x, end_y, (int)xm, (int)ym);
    g.drawLine(end_x, end_y, (int)xn, (int)yn);
  }

  public void paintTriangle(Graphics g, int start_x, int start_y, int end_x, int end_y){
    int arrowW = 10, arrowH = 10;
    g.drawLine(start_x, start_y, end_x, end_y);
    int dx = end_x - start_x, dy = end_y - start_y;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
    double sin = dy/D, cos = dx/D;
    x = xm*cos - ym*sin + start_x;
    ym = xm*sin + ym*cos + start_y;
    xm = x;
    x = xn*cos - yn*sin + start_x;
    yn = xn*sin + yn*cos + start_y;
    xn = x;
    int[] xpoints = {end_x, (int) xm, (int) xn};
    int[] ypoints = {end_y, (int) ym, (int) yn};

    g.fillPolygon(xpoints, ypoints, 3);
  }

  public void paintDiamond(Graphics g, int start_x, int start_y, int end_x, int end_y){
    int diamondW = 10, diamondH = 10;
    g.drawLine(start_x, start_y, end_x, end_y);
    int dx = end_x - start_x, dy = end_y - start_y;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
    double sin = dy/D, cos = dx/D;
    x = xm*cos - ym*sin + start_x;
    ym = xm*sin + ym*cos + start_y;
    xm = x;
    x = xn*cos - yn*sin + start_x;
    yn = xn*sin + yn*cos + start_y;
    xn = x;
    // 分點公式算出線上的點, 三角形的三個點與這個點連線即為一個菱形
    double xq = (diamondH*2/D)*start_x + ((D-diamondH*2)/D)*end_x;
    double yq = (diamondH*2/D)*start_y + ((D-diamondH*2)/D)*end_y;

    int[] xpoints = {end_x, (int) xm, (int) xq, (int) xn};
    int[] ypoints = {end_y, (int) ym, (int) yq, (int) yn};

    g.fillPolygon(xpoints, ypoints, 4);

  }

}
