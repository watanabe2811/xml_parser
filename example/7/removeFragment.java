import com.ximpleware.*;
public class removeFragment {
        public static void main(String[] args) throws Exception
        {
                int i;
                VTDGen vg = new VTDGen();
                AutoPilot ap = new AutoPilot();
                ap.selectXPath("/root/b");
                XMLModifier xm = new XMLModifier();
                if (vg.parseFile("d:/Java_tutorial_by_code_examples/7/input.xml", true))
                {
                    VTDNav vn = vg.getNav();
                    ap.bind(vn);
                    xm.bind(vn);
                    while ((i = ap.evalXPath()) != -1)
                    {
                        // remove the cursor element in the embedded VTDNav object 
                        xm.remove();
                    }
                    xm.output("d:/Java_tutorial_by_code_examples/7/new.xml");
                }
        }    
}


