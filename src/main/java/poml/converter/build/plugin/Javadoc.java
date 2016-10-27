package poml.converter.build.plugin;

import java.util.HashMap;
import java.util.Map;

import poml.Converter;
import poml.in.Poml;
import poml.out.Xml;
import poml.tool.converter.Tmpl;

public class Javadoc implements Converter {
  
  @Override public String name() { return "javadoc"; }

  @Override public void convert(Poml poml, Xml xml) {
    if (poml.conf.none(name())) {
      print(new HashMap<String, String>(1), xml);
      return;
    }
    print(poml.conf.map(name()), xml);
  }
  private void print(Map<String, String> map, Xml xml) {
    Put.defaults("ver", "2.10.4", map);
    xml.out.print(Tmpl.render(
      "/converter/build/plugin/javadoc.tmpl",
      map
    ));
  }
}
