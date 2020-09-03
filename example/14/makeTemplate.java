import com.ximpleware.*;

public class makeTemplate {
    public static byte[] ba0, ba1, ba2, ba3, ba4, ba5;

    public static void main(String[] args) throws Exception {

	ba0 = "                      ".getBytes();
        ba1 = "              ".getBytes();
        ba2 = "       ".getBytes();
        ba3 = "              ".getBytes();
        ba4 = "        ".getBytes();
        ba5 = "        ".getBytes();
        VTDGen vg = new VTDGen();
        BookMark bm = new BookMark();
        AutoPilot ap = new AutoPilot();

        XMLModifier xm = new XMLModifier();
        ap.selectXPath("/CATALOG/CD");

        if (vg.parseFile("old_cd.xml", false)) {
            VTDNav vn = vg.getNav();
            ap.bind(vn);
            xm.bind(vn);
            int i;
            //Insert spaces which will later be edited on
            while ((i = ap.evalXPath()) != -1) {
		convert(vn,xm);
            }
            xm.output("cd_Template.xml");
        }
    }
    
    public static void convert(VTDNav vn, XMLModifier xm) throws Exception{
        int i = -1;
        vn.toElement(VTDNav.FIRST_CHILD);
        i = vn.getText();
        xm.updateToken(i,ba0);
        
        vn.toElement(VTDNav.NEXT_SIBLING);
        i = vn.getText();
        xm.updateToken(i,ba1);
        
        vn.toElement(VTDNav.NEXT_SIBLING);
        i = vn.getText();
        xm.updateToken(i,ba2);
        
        vn.toElement(VTDNav.NEXT_SIBLING);
        i = vn.getText();
        xm.updateToken(i,ba3);
        
        vn.toElement(VTDNav.NEXT_SIBLING);
        i = vn.getText();
        xm.updateToken(i,ba4);
        
        vn.toElement(VTDNav.NEXT_SIBLING);
        i = vn.getText();
        xm.updateToken(i,ba5);
        
        vn.toElement(VTDNav.PARENT);
    }
}

