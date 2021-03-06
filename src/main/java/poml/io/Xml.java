package poml.io;

// pom.xml
public class Xml {
  public static final String
    sp2="  ", sp4="    ", sp6="      ",
    sp8="        ", sp10="          ";
  private static final String nl = System.lineSeparator();
  private static final int nlLen = nl.length();

  private StringBuilder xml = new StringBuilder();
  public String toString() { return xml.toString(); }

  // -> api to add xml element.
  public Xml txt(String s) {
    xml.append(s);
    return this;
  }
  public void nl() {
    xml.append(nl);
  }
  public void line(String l) {
    xml.append(l).append(nl);
  }

  // sp="  "
  // key={"k1", "k2", ...}
  // val={"v1", "v2", ...}
  //   -> "  <k1>v1</k1>" + nl + "  <k2>v2..."
  public void tags(
    String sp, String[] key, String[] val
  ) {
    for (int i = 0; i < val.length; i++) {
      if (val[i] == null || "".equals(val[i])) continue;
      xml.append(sp);
      xml.append("<").append(key[i]).append(">");
      xml.append(val[i]);
      xml.append("</").append(key[i]).append(">");
      nl();
    }
  }
  // sp="  "
  // kv={"k1>v1", "k2>v2", ...}
  //   -> "  <k1>v1</k1>" + nl + "  <k2>v2..."
  public void kv(String sp, String[] kv) {
    for (int i=0; i<kv.length; i++) {
      kv(sp, kv[i]);
    }
  }
  // sp="  "
  // kv="k>v"
  //  -> "  <k>v</k>"
  public void kv(String sp, String kv) {
    int gt = kv.indexOf('>');
    if (gt == -1) return;  // not k>v
    String k = kv.substring(0, gt);
    xml.append(sp).append(
      "<").append(kv).append("</").append(k).append(">"
    ).append(nl);
  }
  // sp="  "
  // x="  <k1>v1</k1>" + nl + "  <k2>v2..."
  //   -> "    <k1>v1</k1>" + nl + "    <k2>v2..."
  public void xml(String sp, String x) {
    for (int s=0, e=0; ;s=e) {
      e = x.indexOf(nl, s);
      if (e == -1) break;
      e = e+nlLen;
      xml.append(sp).append(
        x.substring(s, e)
      );
    }
  }
}