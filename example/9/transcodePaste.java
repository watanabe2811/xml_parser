import com.ximpleware.*;
public class transcodedPaste {
    public static void main(String[] args) throws Exception {
        
        // test2.xml encoded in UTF-16LE format
        VTDGen vg = new VTDGen();
       
        if (vg.parseFile("D:/vtd-xml-tutorials/java_tutorial_by_code_examples/9/test2.xml",false)==false)
            return;
        VTDNav vn = vg.getNav();
        byte[] ba = null;
        long l;
        ba = vn.getXML().getBytes();
        l = vn.getElementFragment();

        // test.xml encoded in UTF-8 format
        if (vg.parseFile("D:/vtd-xml-tutorials/java_tutorial_by_code_examples/9/test.xml", false)== false)
            return;
        
        VTDNav vn2 = vg.getNav();
        vn2.toElement(VTDNav.FIRST_CHILD);
        XMLModifier xm = new XMLModifier(vn2);

        // insert byte array encoded in UTF-16 into a UTF-8 doc
        xm.insertAfterElement(vn.getEncoding(), ba,(int)l, (int)(l>>32));
        xm.insertBeforeElement(vn.getEncoding(), ba,(int)l, (int)(l>>32));

        xm.output("D:/vtd-xml-tutorials/java_tutorial_by_code_examples/9/out.xml");        
    }
}

