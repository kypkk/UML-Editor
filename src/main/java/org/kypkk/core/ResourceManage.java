package org.kypkk.core;

import org.kypkk.App;

import java.net.URL;

public class ResourceManage {

  public static URL getResource(String path){
    return App.class.getResource(path);
  }
}
