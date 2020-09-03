import com.ximpleware.*;

public class hello_world{
	public static void main(String[] args) throws ParseException,NavException{
		VTDGen vg = new VTDGen();
		if (vg.parseFile("d:/java_tutorial_by_code_examples/1/input.xml",true)){
			VTDNav vn = vg.getNav();
			//toElementNS is the namespace aware version of toElement which navigates the cursor
			if (vn.toElementNS(VTDNav.FIRST_CHILD, "someURL", "b")){
				int i= vn.getText(); // get the VTD record index
				if (i!=-1){
					// convert i into string before printing, 
					// toNormalizedString(i) and toRawString(i) are two other options
					System.out.println("the text node value at "+i+" ==> "+vn.toString(i));
				}
			}
		}
	}
}
