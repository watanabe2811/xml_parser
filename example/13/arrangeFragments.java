import com.ximpleware.*;
import java.io.*;
public class arrangeFragments{
	public static void main(String[] args) throws Exception	{
		VTDGen vg = new VTDGen();
		AutoPilot ap0 = new AutoPilot();
		AutoPilot ap1 = new AutoPilot();
		AutoPilot ap2 = new AutoPilot();
		ap0.selectXPath("/root/a");
		ap1.selectXPath("/root/b");
		ap2.selectXPath("/root/c");
		
		if (vg.parseFile("d:/Java_tutorial_by_code_examples/10/input.xml", false))
		{
			VTDNav vn = vg.getNav();
			ap0.bind(vn);
			ap1.bind(vn);
			ap2.bind(vn);
			FileOutputStream fos = new FileOutputStream("d:/Java_tutorial_by_code_examples/10/new.xml");
			//fos.Write("<root>".getBytes());
			byte[] ba0, ba1, ba2, ba3, ba4;
			//ba0 = eg.GetBytes("
			ba1 = "<root>".getBytes();
			ba2 = "</root>".getBytes();
			ba3 = "\r\n".getBytes();
			fos.write(ba1);
			byte[] ba = vn.getXML().getBytes();

			while (ap0.evalXPath() != -1)
			{
				long l = vn.getElementFragment();
				int offset = (int)l;
				int len = (int)(l >> 32);
				fos.write(ba3);
				fos.write(ba, offset, len);
			}
			ap0.resetXPath();
			while (ap1.evalXPath() != -1)
			{
				long l = vn.getElementFragment();
				int offset = (int)l;
				int len = (int)(l >> 32);
				fos.write(ba3);
				fos.write(ba, offset, len);
			}
			ap1.resetXPath();
			while (ap2.evalXPath() != -1)
			{
				long l = vn.getElementFragment();
				int offset = (int)l;
				int len = (int)(l >> 32);
				fos.write(ba3);
				fos.write(ba, offset, len);
			}
			ap2.resetXPath();
			fos.write(ba3);
			fos.write(ba2);
		}
	}
}


