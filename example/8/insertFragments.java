import com.ximpleware.*;
public class insertFragments{
        public static void main(String[] args) throws Exception {
                int i;
                VTDGen vg = new VTDGen();
                AutoPilot ap = new AutoPilot();
                ap.selectXPath("/root/b");
                XMLModifier xm = new XMLModifier();
                if (vg.parseFile("d:/Java_tutorial_by_code_examples/8/input.xml", true))
                {
                    VTDNav vn = vg.getNav();
                    ap.bind(vn);
                    xm.bind(vn);
                    while ((i = ap.evalXPath()) != -1)
                    {
                        // both methods operate on the embedded VTDNav object's cursor element
                        xm.insertBeforeElement("<lala/>\r\n");
                        xm.insertAfterElement("\r\n<lala/>");
                    }
                    xm.output("d:/Java_tutorial_by_code_examples/8/new.xml");
                }
        }    
}
