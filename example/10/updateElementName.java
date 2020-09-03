import com.ximpleware.*;
/*this java app changes name of all the elements to 'lalala'*/

public class updateElementName {
    public static void main(String[] args) throws Exception {
        VTDGen vg = new VTDGen();
        if (vg.parseFile("d:/test.xml",false)){
            VTDNav vn = vg.getNav();
            AutoPilot ap = new AutoPilot(vn);
            XMLModifier xm = new XMLModifier(vn);
            ap.selectXPath("//*");
            int i;
            while ((i = ap.evalXPath())!=-1){
                xm.updateElementName("lalala");
            }
            xm.output("d:/out.xml");
        }
    }
}
