import com.ximpleware.*;
// xpath without name space
public class xpath
{
	public static void Main(String[] args) throws ParseException, NavException, XPathParseException, XPathEvalException{
            VTDGen vg = new VTDGen();
            AutoPilot ap = new AutoPilot();
            int i;
            ap.selectXPath("/a/b/text()");
            if (vg.parseFile("d:/java_tutorial_by_code_examples/2/input.xml",true)){
                VTDNav vn = vg.getNav();
                ap.bind(vn); // apply XPath to the VTDNav instance, you can associate ap to different vns
                // AutoPilot moves the cursor for you, as it returns the index value of the evaluated node
                while((i=ap.evalXPath())!=-1){
                    // notice that i always is equal to vn.getCurrentIndex()!!!
                    System.out.println("the text node index val is "+ 
                        i +" the text string ==>"+vn.toString(i));
                    // below is equivalent to 
                    // vn's cursor is what gets moved by AutoPilot here
                    System.out.println("the text node index val is " + 
                        i + " the text string ==>" + vn.toString(vn.getCurrentIndex()));
                }
	    }
	}
}
