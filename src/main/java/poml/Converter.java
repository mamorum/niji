package poml;

import java.util.Map;

public abstract class Converter {

  public abstract String name();
  public abstract void convert(Src src, Dst dst);
  
  public static String nl = System.lineSeparator();
  public static String
    sp2="  ",
    sp4=sp2+sp2,
    sp6=sp2+sp4,
    sp8=sp2+sp6,
    sp10=sp2+sp8;

  // utilities -->
  public void putDefault(
      String k, String v, Map<String, String> to
  ) {
    if (to.get(k) == null) to.put(k, v);
  }
}
