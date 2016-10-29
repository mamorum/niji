package poml.conv;

import poml.in.Poml;
import poml.out.Xml;

public interface Converter {

  String name();
  void convert(Poml poml, Xml xml);

  public static String
    sp2="  ",
    sp4=sp2+sp2,
    sp6=sp2+sp4,
    sp8=sp2+sp6,
    sp10=sp2+sp8;
}
