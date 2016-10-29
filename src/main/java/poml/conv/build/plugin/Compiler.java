package poml.conv.build.plugin;

import java.util.Map;

import poml.conv.Converter;
import poml.in.Poml;
import poml.out.Xml;
import poml.tool.Assert;
import poml.tool.Tmpl;

public class Compiler implements Converter {

  @Override public String name() { return "compiler"; }

  @Override public void convert(Poml poml, Xml xml) {
    Map<String, String> map = poml.conf.map(name());
    Assert.exists(
      new String[]{"source", "target"},
      map, name()
    );
    Tmpl.render(
      "/converter/build/plugin/compiler.tmpl",
      map, xml
    );
  }
}