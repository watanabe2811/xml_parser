import com.ximpleware.*;

public class insertAttr{
        public static void main(String[] args) throws Exception{
                int i;
                VTDGen vg = new VTDGen();
                AutoPilot ap = new AutoPilot();
                XMLModifier xm = new XMLModifier();
                VTDNav vn = vg.loadIndex("d:/Java_tutorial_by_code_examples/6/input.vxl");
                ap.selectXPath("/a/b");
                ap.bind(vn);
                xm.bind(vn);
                while ((i = ap.evalXPath()) != -1){
                    // operate on the cursor element
                    xm.insertAttribute(" attr1='val' attr2='val2'");
                }
                xm.output("d:/Java_tutorial_by_code_examples/6/new2.xml"); 
        }    
}


