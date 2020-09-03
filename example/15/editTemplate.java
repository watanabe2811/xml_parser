import com.ximpleware.*;
import java.io.*;
public class editTemplate
{
	public static void main(String[] args) throws Exception
	{
		VTDGen vg = new VTDGen();
		FileOutputStream fos = new FileOutputStream("new_cd.xml");
		AutoPilot ap = new AutoPilot();
		ap.selectXPath("/CATALOG/CD");
		if (vg.parseFile("cd_Template.xml", false))
		{
			VTDNav vn = vg.getNav();
			ap.bind(vn);
			if (ap.evalXPath() == -1)
			{
				System.out.println("XPath eval failed");
				System.exit(0);
			}
			fillTemplate(vn, "Empire Burlesque", "Bob Dylan", "USA", "Columbia", 10.90, 1985);
			if (ap.evalXPath() == -1)
			{
				System.out.println("XPath eval failed");
				System.exit(0);
			}
			fillTemplate(vn, "Still Got the Blues", "Gary More", "UK", "Virgin Records", 10.20, 1990);
			// dump out the XML
			fos.write(vn.getXML().getBytes());
			fos.close();
		}
	}
	public static void fillTemplate(VTDNav vn,
			String title, String artist, String country,
			String company, double price, int year) throws NavException
	{

		int i = -1;
		if (vn.toElement(VTDNav.FIRST_CHILD))
		{
			vn.overWrite(vn.getText(), title.getBytes());
			vn.toElement(VTDNav.NEXT_SIBLING);
			vn.overWrite(vn.getText(), artist.getBytes());
			vn.toElement(VTDNav.NEXT_SIBLING);
			vn.overWrite(vn.getText(), country.getBytes());
			vn.toElement(VTDNav.NEXT_SIBLING);
			vn.overWrite(vn.getText(), company.getBytes());
			vn.toElement(VTDNav.NEXT_SIBLING);
			vn.overWrite(vn.getText(), (price + "").getBytes());
			vn.toElement(VTDNav.NEXT_SIBLING);
			vn.overWrite(vn.getText(), (year + "").getBytes());
		}
		vn.toElement(VTDNav.PARENT);
	}
}

