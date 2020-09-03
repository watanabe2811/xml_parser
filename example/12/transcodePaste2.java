import com.ximpleware.*;
public class transcodePaste2 {
    public static void main(String[] args) throws Exception{
        
            // test2 encoded in UTF-16LE format
            VTDGen vg = new VTDGen();

            if (vg.parseFile("D:/vtd-xml-tutorials/java_tutorial_by_code_examples/12/test2.xml", true) == false)
                return;
            VTDNav vn = vg.getNav();
            byte[] ba = null;
            long l;
            ba = vn.getXML().getBytes();
            ElementFragmentNs efn = vn.getElementFragmentNs();
            // test encoded in UTF-8
            if (vg.parseFile("D:/vtd-xml-tutorials/java_tutorial_by_code_examples/12/test.xml", false) == false)
                return;

            VTDNav vn2 = vg.getNav();
            vn2.toElement(VTDNav.FIRST_CHILD);
            XMLModifier xm = new XMLModifier(vn2);

            // insert UTF-16-LE encoded elementFragmentNs into a UTF-8 encoded doc 
            xm.insertAfterElement(efn);
            xm.insertBeforeElement(efn);
            // transcoding is done underneath
            xm.output("D:/vtd-xml-tutorials/java_tutorial_by_code_examples/12/out.xml");
       
    }
}

