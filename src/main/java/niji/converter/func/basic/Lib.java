package niji.converter.func.basic;

import niji.Converter.Func;
import niji.converter.Src;
import niji.converter.util.Tag;

public class Lib implements Func {

  public static String key = "lib";
  
  static String[] tmpls = {
      "<groupId>0</groupId>", 
      "<artifactId>1</artifactId>",
      "<version>2</version>",
      "<scope>3</scope>",
      "<optional>4</optional>",
      "<type>5</type>"
  };

  public static void addChild(int depth, String lib, Tag parent) {
    Tag child =Tag.init(depth+2, "<dependency>", "</dependency>");
    String[] childVals = lib.split(":");
    for (int i = 0; i < childVals.length; i++) {
      child.line(
        tmpls[i].replace(
            Integer.toString(i),
            childVals[i].trim()
        )
      );
    }
    parent.child(child);
  }

  @Override public void accept(Src src, StringBuilder xml) {
    String ppv = src.p.getProperty(key);
    Tag parent = Tag.init(
        src.indent, "<dependencies>", "</dependencies>"
    );
    for (String lib: ppv.split(",")) {
      addChild(src.indent, lib.trim(), parent);
    }
    xml.append(parent.string());
  }
}
