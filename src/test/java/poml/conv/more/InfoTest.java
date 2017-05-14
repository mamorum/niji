package poml.conv.more;

import static org.junit.Assert.fail;

import org.junit.Test;

import poml.conv.ConvTestCase;
import poml.in.Poml;

public class InfoTest extends ConvTestCase {

  Info conv = new Info();

  @Test public void name() {
    poml = Poml.parse(data(
      "info=name>INFO"
    ));
    conv.convert(poml, xml);
    result(
      "  <name>INFO</name>" + nl
    );
  }

  @Test public void all() {
    poml = Poml.parse(data(
      "info=" + nl +
      "  name>INFO," + nl +
      "  description>More Project Infomation," + nl +
      "  url>https://github.com/mamorum/poml," + nl +
      "  inceptionYear>2016" + nl
    ));
    conv.convert(poml, xml);
    result(
        "  <name>INFO</name>" + nl +
        "  <description>More Project Infomation</description>" + nl +
        "  <url>https://github.com/mamorum/poml</url>" + nl +
        "  <inceptionYear>2016</inceptionYear>" + nl
    );
  }

  @Test public void ng_badConf() {
    poml = Poml.parse(data(
      "info=bad-conf"
    ));
    try {
      conv.convert(poml, xml);
      fail();
    } catch (IllegalStateException e) {
      msg(e).starts("Bad config");
    }
  }
}
