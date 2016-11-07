package poml.conv.build.plugin;

import java.util.Map;

import poml.conv.Converter;
import poml.in.Poml;
import poml.out.Xml;
import poml.tool.Func.Assert;
import poml.tool.Func.Put;
import poml.tool.Tmpl;

public class Exec implements Converter {
  
  @Override public String name() { return "exec"; }

  @Override public void convert(Poml poml, Xml xml) {
    Map<String, String> map = poml.conf.map(name(), false);
    Assert.notNull("mainClass", map, name());
    Put.defaults("ver", "1.5.0", map);
    Tmpl.render(
      "/converter/build/plugin/exec.tmpl",
      map, xml
    );
  }
}
