/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package vn.com.watanabe.parser.xml;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;

public class App {
    private VTDNav nav;
    private List<String> lines;
    private VTDGen vg = new VTDGen();

    public String getGreeting() {
        try {

            int i;
            File file = new File("data", "test1.xml");
            lines = Files.readAllLines(Paths.get(file.getPath()));
            for (String line : lines) {
                System.out.println(line);
                vg.setDoc(line.getBytes());
                vg.parse(true);
                VTDNav vn = vg.getNav();
                AutoPilot ap = new AutoPilot();
                ap.bind(vn);
                System.out.println(getNodeText(vn, ap, "c1"));
                System.out.println(getNodeText(vn, ap, "c2"));
                System.out.println(getNodeText(vn, ap, "c3"));
                System.out.println(getNodeText(vn, ap, "c3[@m=2]"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "okie";
    }

    public String getNodeText(VTDNav vn,AutoPilot ap, String xPath) throws NavException, XPathEvalException, XPathParseException {
       String v= "";
       int i;
        ap.selectXPath(xPath);
        // v=vn.toString(vn.getText());
        while((i=ap.evalXPath()) != -1){
            v+=vn.toString(vn.getText());
        }
        ap.resetXPath();
        return v;
    }

    public static void main(final String[] args) {
        new App().getGreeting();
    }
}
