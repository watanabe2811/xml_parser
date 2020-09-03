import com.ximpleware.*;
// grab a ns-compensated fragment from document a and drop it into document b

public class nsFragments{
	public static void main(String[] args) throws Exception	{
		int i;
		VTDGen vg1 = new VTDGen();
		VTDGen vg2 = new VTDGen();
		AutoPilot ap = new AutoPilot();
		ap.selectXPath("/root/b");
		XMLModifier xm = new XMLModifier();
		if (vg1.parseFile("d:/Java_tutorial_by_code_examples/9/input2.xml", true) == false
			|| vg2.parseFile("d:/Java_tutorial_by_code_examples/9/input1.xml", true) == false)
		{
			return;
		}
		VTDNav vn1 = vg1.getNav();
		VTDNav vn2 = vg2.getNav();
		ap.bind(vn2);
		xm.bind(vn2);
		if (vn1.toElementNS(VTDNav.FIRST_CHILD, "someURL2", "b"))
		{
			ElementFragmentNs efn = vn1.getElementFragmentNs();
			while ((i = ap.evalXPath()) != -1)
			{
				// both methods operate on the embedded VTDNav object's cursor element
				xm.insertBeforeElement(efn);
				xm.insertAfterElement(efn);
			}
			xm.output("d:/Java_tutorial_by_code_examples/9/new.xml");
		}
	}
}

