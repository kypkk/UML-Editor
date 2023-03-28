package org.kypkk.graphic.UMLObjects;

public class LineObj {
  private final UMLObj start_obj;
  private final UMLObj end_obj;
  private final UMLObj.portDirection start_port;
  private final UMLObj.portDirection end_port;
  private final Linetype type;

  public enum Linetype{
    ASSOCIATION_LINE, COMPOSITION_LINE, GENERALIZATION_LINE
  }

  public LineObj(UMLObj start_obj, UMLObj end_obj, UMLObj.portDirection start_port, UMLObj.portDirection end_port, Linetype type){
    this.start_obj = start_obj;
    this.end_obj = end_obj;
    this.start_port = start_port;
    this.end_port = end_port;
    this.type = type;
  }

  public UMLObj getStart_obj(){
    return start_obj;
  }

  public UMLObj getEnd_obj(){
    return end_obj;
  }

  public UMLObj.portDirection getStart_port(){
    return start_port;
  }

  public UMLObj.portDirection getEnd_port(){
    return end_port;
  }

  public Linetype getType(){
    return this.type;
  }

}
