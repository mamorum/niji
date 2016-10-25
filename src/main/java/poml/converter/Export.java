package poml.converter;

import java.util.HashMap;

import poml.Converter;
import poml.converter.basic.Depend;
import poml.converter.basic.Depends;
import poml.converter.basic.Pkg;
import poml.converter.basic.Property;
import poml.converter.build.plugin.Compiler;
import poml.converter.build.plugin.Exec;
import poml.converter.build.plugin.Fatjar;
import poml.converter.build.plugin.Gpg;
import poml.converter.build.plugin.Javadoc;
import poml.converter.build.plugin.Source;
import poml.converter.env.Dist;
import poml.converter.more.Info;
import poml.converter.project.Model4;

public class Export {

  private static final Converter[] target
    = new Converter[] {
      // project
      new Model4.Start(), new Model4.End(),
      // basic
      new Pkg(), new Depends(), new Depend(),
      new Property(),
      // build.plugin
      new Compiler(), new Source(), new Javadoc(),
      new Gpg(), new Fatjar(), new Exec(),
      // more
      new Info(),
      // env
      new Dist()
  };

  public static HashMap<String, Converter> converters() {
    HashMap<String, Converter> map = new HashMap<>();
    for (Converter c: target) map.put(c.name(), c);
    return map;
  }
}
